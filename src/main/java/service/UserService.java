package service;

import dao.impl.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import util.JwtUtil;
import util.ServletUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserService {
    private final UserDAO userDAO;
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final JwtUtil jwtUtil;
    private ServletUtil servletUtil;

    public UserService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.userDAO = new UserDAO();
        this.jwtUtil = new JwtUtil();
        this.servletUtil = new ServletUtil(request, response);// Initialize your JWT utility here
    }

    public void listUsers() throws ServletException, IOException {
        listUsers(null);
    }

    public void listUsers(String message) throws ServletException, IOException {
        List<Users> listUsers = userDAO.listAll();
        request.setAttribute("listUsers", listUsers);

        if (message != null) {
            request.setAttribute("message", message);
        }

        servletUtil.forwardToPage("/admin/user/list_users.jsp");
    }

    public void showRegisterForm() throws ServletException, IOException {
        servletUtil.forwardToPage("/frontend/register.jsp");
    }

    public void showCreateUser() throws ServletException, IOException {
        servletUtil.forwardToPage("/admin/user/create_user.jsp");
    }

    public void createUser() throws ServletException, IOException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Users existingUser = userDAO.findByEmail(email);

        if (existingUser != null) {
            servletUtil.setErrorMessage("Không thể tạo tài khoản. Đã có một tài khoản có email " + email);
            servletUtil.forwardToPage("/common/message.jsp");
        } else {
            Users newUser = new Users();
            readFields(request, newUser);
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(password);
            newUser.setPassword(encodedPassword);
            userDAO.create(newUser);
            listUsers("Tài khoản đã tạo thành công!!");
        }
    }

    public void editUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        Users user = userDAO.get(userId);

        request.setAttribute("user", user);
        servletUtil.forwardToPage("/admin/user/update_user.jsp");
    }

    public void updateUser() throws ServletException, IOException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Users userById = userDAO.get(userId);

        Users userByEmail = userDAO.findByEmail(email);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(password);
        Users updatedUser = new Users();
        readFields(request, updatedUser);
        updatedUser.setId(userId);
        updatedUser.setPassword(encodedPassword);
        userDAO.update(updatedUser);
        listUsers("Tài khoản được cập nhật thành công!!");

    }

    public void deleteUser() throws ServletException, IOException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        int userId = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(userId);
        listUsers("User has been deleted successfully");
    }

    public void readFields(HttpServletRequest request, Users user) {
        // Đọc dữ liệu từ request và gán vào đối tượng User
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String birthdayStr = request.getParameter("birthday");
        String genderStr = request.getParameter("gender");
        String roleStr = request.getParameter("role");

        // Gán giá trị vào đối tượng User
        user.setFullname(fullname);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);

        // Chuyển đổi chuỗi ngày sinh thành đối tượng Date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birthday = formatter.parse(birthdayStr);
            user.setBirthday(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
            // Xử lý lỗi nếu không thể parse ngày sinh
        }

        // Chuyển đổi chuỗi gender thành boolean
        boolean gender = Boolean.parseBoolean(genderStr);
        user.setGender(gender);

        // Chuyển đổi chuỗi role thành boolean
        boolean role = Boolean.parseBoolean(roleStr);
        user.setRole(role);
    }

    // Hàm kiểm tra và trả về người dùng đang đăng nhập
    public Users loggedUser(HttpServletRequest request) {
        // Lấy token từ session hoặc cookie
        String token = (String) request.getSession().getAttribute("token");
        if (token == null) {
            token = extractTokenFromCookies(request); // Nếu không có trong session, kiểm tra cookie
        }

        // Nếu không tìm thấy token, người dùng chưa đăng nhập
        if (token == null || token.isEmpty()) {
            return null;
        }

        // Trích xuất email từ token và tìm người dùng từ email
        String email = jwtUtil.extractUsername(token);
        if (email != null) {
            try {
                return userDAO.findByEmail(email);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return null; // Trả về null nếu không có thông tin người dùng
    }

    // Hàm hỗ trợ: Lấy token từ cookie
    private String extractTokenFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwt".equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public void showLogin() throws Exception {
        String loginPage = "/frontend/login.jsp";
        servletUtil.forwardToPage(loginPage);
    }
}

