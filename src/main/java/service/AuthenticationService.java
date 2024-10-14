package service;

import dao.impl.UserDAO;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import util.JwtUtil;


public class AuthenticationService {
    private UserDAO userDAO;
    private JwtUtil jwtUtil;

    public AuthenticationService(UserDAO userDAO, JwtUtil jwtUtil) {
        this.userDAO = userDAO;
        this.jwtUtil = jwtUtil;
    }

    public boolean login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String remember = request.getParameter("rememberMe");

        Users user = userDAO.findByEmail(email);

        if (user == null) {
            return false; // Email không tồn tại
        }

        // So sánh mật khẩu nhập vào với mật khẩu đã mã hóa
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean loginResult = passwordEncoder.matches(password, user.getPassword());

        if (loginResult) {
            String token = jwtUtil.generateToken(email); // Tạo JWT
            request.getSession().setAttribute("useremail", email);
            request.getSession().setAttribute("token", token); // Lưu token vào session
            Users loggedUser = userDAO.findByEmail(email); // Lấy thông tin người dùng sau khi đăng nhập thành công
            // Lưu đối tượng loggedUser vào session
            request.getSession().setAttribute("loggedUser", loggedUser);
            // Kiểm tra "Remember Me"
            if ("on".equals(remember)) {
                Cookie jwtCookie = new Cookie("jwt", token);
                jwtCookie.setHttpOnly(true);
                jwtCookie.setSecure(true);
                jwtCookie.setPath("/");
                jwtCookie.setMaxAge(60 * 60 * 24 * 7); // Token tồn tại 7 ngày
                response.addCookie(jwtCookie);
            }
            return true;
        }

        return false; // Sai mật khẩu
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) {
        // Xóa thông tin đăng nhập khỏi session
        request.getSession().invalidate();

        // Xóa cookie nếu tồn tại
        Cookie jwtCookie = new Cookie("jwt", null);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setSecure(true);
        jwtCookie.setPath("/");
        jwtCookie.setMaxAge(0); // Xóa cookie ngay lập tức
        response.addCookie(jwtCookie);
    }
}
