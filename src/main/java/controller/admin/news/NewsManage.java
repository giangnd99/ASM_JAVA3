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

@WebServlet("/admin/list_news")
public class NewsManage extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            NewsService service = new NewsService(request, response);
            service.listNews();
        } catch (Exception ex) {
            Logger.getLogger(NewsManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

