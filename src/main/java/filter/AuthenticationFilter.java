package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Users;
import service.UserService;

import java.io.IOException;

public class AuthenticationFilter implements Filter {
    private UserService userService;
    private HttpServletRequest httpRequest;
    private HttpServletResponse httpResponse;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Khởi tạo UserService với các thành phần cần thiết
        this.userService = new UserService(httpRequest, httpResponse);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        httpRequest = (HttpServletRequest) request;
        httpResponse = (HttpServletResponse) response;

        // Kiểm tra người dùng đang đăng nhập
        Users loggedUser = userService.loggedUser(httpRequest);

        // Các trang yêu cầu đăng nhập như trang admin, profile, home...
        String[] protectedUrls = {"/admin", "/profile"};

        String requestPath = httpRequest.getRequestURI();

        // Kiểm tra nếu request đang truy cập vào trang yêu cầu đăng nhập
        boolean isProtectedPage = false;
        for (String url : protectedUrls) {
            if (requestPath.startsWith(url)) {
                isProtectedPage = true;
                break;
            }
        }

        if (isProtectedPage && loggedUser == null) {
            // Nếu là trang bảo vệ và người dùng chưa đăng nhập -> chuyển hướng về login
            httpResponse.sendRedirect("/login.jsp");
        } else {
            // Nếu người dùng đã đăng nhập hoặc không cần đăng nhập cho trang này -> tiếp tục request
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Hủy bỏ nếu cần
    }
}
