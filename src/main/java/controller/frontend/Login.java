package controller.frontend;

import dao.impl.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AuthenticationService;
import service.UserService;
import util.JwtUtil;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AuthenticationService authService;

    @Override
    public void init() throws ServletException {
        // Giả sử bạn sẽ inject DAO và JwtUtil vào đây
        this.authService = new AuthenticationService(new UserDAO(), new JwtUtil());
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService(request, response);
        try {
            userService.showLogin();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            boolean loginSuccess = authService.login(request, response);
            if (loginSuccess) {
                // Đăng nhập thành công, điều hướng đến trang chủ
                response.sendRedirect(request.getContextPath() + "/");
            } else {
                // Đăng nhập thất bại, điều hướng về trang thông báo lỗi
                request.setAttribute("message", "Đăng nhập thất bại!");
                request.getRequestDispatcher("/common/message.jsp").forward(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
