package controller.admin.newsletter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NewsLetterService;
import service.NewsService;

import java.io.IOException;

@WebServlet("/admin/create_newsletter")
public class CreateNewsletterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsLetterService newsLetterService = new NewsLetterService(req, resp);
        try {
            newsLetterService.createNewsletter();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
