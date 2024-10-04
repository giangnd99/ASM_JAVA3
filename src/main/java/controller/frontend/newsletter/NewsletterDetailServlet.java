package controller.frontend.newsletter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NewsLetterService;

import java.io.IOException;

@WebServlet()
public class NewsletterDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsLetterService newsLetterService = new NewsLetterService(req, resp);
        newsLetterService.listNewsletters();
    }
}
