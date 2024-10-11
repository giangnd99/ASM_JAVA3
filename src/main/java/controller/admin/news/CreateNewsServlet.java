package controller.admin.news;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NewsService;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@MultipartConfig
@WebServlet("/admin/create_news")
public class CreateNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsService newsService = new NewsService(req, resp);
        try {
            newsService.showNewsNewForm();
        } catch (Exception ex) {
            Logger.getLogger(CreateNewsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsService newsService = new NewsService(req, resp);
        try {
            newsService.createNews();
        } catch (Exception e) {
            throw new RuntimeException("Error when create news" + e, e.getCause());
        }
    }
}
