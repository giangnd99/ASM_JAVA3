package controller.admin.news;

import dao.impl.NewsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.News;
import service.NewsService;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.nio.file.Paths;

@WebServlet("/admin/update_news")
@MultipartConfig
public class UpdateNewsServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -6725822377987848189L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsService service = new NewsService(req, resp);
        try {
            service.editNews();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int newsId = Integer.parseInt(req.getParameter("newsId"));
        System.out.println(newsId);
        NewsService service = new NewsService(req, resp);
        try {
            service.updateNews();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
