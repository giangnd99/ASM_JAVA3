package service;

import controller.frontend.HomePage;
import dao.impl.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import util.JwtUtil;
import util.ServletUtil;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
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
        this.servletUtil = new ServletUtil(request,response);// Initialize your JWT utility here
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

        servletUtil.forwardToPage("/admin/usermanage.jsp");
    }

    public void showRegisterForm() throws ServletException, IOException {
        servletUtil.forwardToPage("/frontend/register.jsp");
    }
    public void createUser() throws ServletException, IOException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");

        Users existingUser = userDAO.findByEmail(email);

        if (existingUser != null) {
            servletUtil.setErrorMessage("Không thể tạo tài khoản. Đã có một tài khoản có email " + email);
            servletUtil.forwardToPage("/common/message.jsp");
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(password);
            Users newUser = new Users(email, fullName, encodedPassword);
            userDAO.create(newUser);
            listUsers("Tài khoản đã tạo thành công!!");
        }
    }

    public void editUser() throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        Users user = userDAO.get(userId);

        request.setAttribute("user", user);
        servletUtil.forwardToPage("user_form.jsp");
    }

    public void updateUser() throws ServletException, IOException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        String email = request.getParameter("email");
        String fullName = request.getParameter("fullname");
        String password = request.getParameter("password");

        Users userById = userDAO.get(userId);

        Users userByEmail = userDAO.findByEmail(email);

        if (userByEmail != null && userByEmail.getId() != userById.getId()) {
            servletUtil.setErrorMessage("Không thể cập nhật vì đã tồn tại email " + email + " already exists.");
            servletUtil.forwardToPage("message.jsp");
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodedPassword = encoder.encode(password);

            Users updatedUser = new Users(userId, email, fullName, encodedPassword);
            userDAO.update(updatedUser);
            listUsers("Tài khoản được cập nhật thành công!!");
        }
    }

    public void deleteUser() throws ServletException, IOException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        int userId = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(userId);
        listUsers("User has been deleted successfully");
    }

    public void showLogin() throws Exception {
        String loginPage = "/frontend/login.jsp";
        servletUtil.forwardToPage(loginPage);
    }

    public void doLogin() throws Exception {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Users user = userDAO.findByEmail(email);
        boolean loginResult = false;

        if (user != null) {
            // So sánh mật khẩu nhập vào với mật khẩu đã mã hóa
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            loginResult = passwordEncoder.matches(password, user.getPassword());


            if (loginResult) {
            String token = jwtUtil.generateToken(email); // Tạo JWT
            request.getSession().setAttribute("useremail", email);
            request.getSession().setAttribute("token", token); // Lưu token vào session

                HomePage homePage = new HomePage();
                homePage.doGet(request, response);
        } else {
            String message = "Đăng nhập thất bại!";
            request.setAttribute("message", message);
            String messagePage = "/common/message.jsp";
            servletUtil.forwardToPage(messagePage);
            }
        }
    }
}
