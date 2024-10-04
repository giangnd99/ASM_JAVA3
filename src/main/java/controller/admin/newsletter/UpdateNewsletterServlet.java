package controller.admin.newsletter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NewsLetterService;

import java.io.IOException;

@WebServlet
public class UpdateNewsletterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsLetterService newsLetterService = new NewsLetterService(req, resp);
        try {
            newsLetterService.updateNewsletter();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
