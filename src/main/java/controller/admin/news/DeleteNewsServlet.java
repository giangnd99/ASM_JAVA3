package controller.admin.news;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NewsService;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/admin/delete_news")
public class DeleteNewsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        NewsService newsService = new NewsService(req, resp);
        try {
            newsService.deleteNews();
        } catch (Exception ex) {
            Logger.getLogger(DeleteNewsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
