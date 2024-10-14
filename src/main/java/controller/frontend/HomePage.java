package controller.frontend;

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

@WebServlet("/")
public class HomePage extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            NewsService service = new NewsService(request, response);
            service.homePage();
        } catch (Exception ex) {
            Logger.getLogger(NewsManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

