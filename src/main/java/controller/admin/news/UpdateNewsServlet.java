package controller.admin.news;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NewsService;

import java.io.IOException;

@WebServlet
public class UpdateNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsService newsService = new NewsService(req,resp);
        try {
            newsService.updateNews();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
