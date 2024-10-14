package controller.frontend.news;
import controller.admin.news.NewsManage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NewsService;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/news_detail")
public class NewsDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            NewsService service = new NewsService(request, response);
            service.viewNewsDetail();
        } catch (Exception ex) {
            Logger.getLogger(NewsManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

