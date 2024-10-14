package controller.frontend;

import dao.impl.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.AuthenticationService;
import util.JwtUtil;

import java.io.IOException;

@WebServlet("/logout")
public class LogOut extends HttpServlet {

    private AuthenticationService authService;

    @Override
    public void init() throws ServletException {
        this.authService = new AuthenticationService(new UserDAO(), new JwtUtil());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        authService.logout(request, response);
        // Sau khi đăng xuất, điều hướng về trang đăng nhập
        response.sendRedirect("/");
    }
}