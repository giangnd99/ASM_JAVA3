package service;

import dao.impl.NewsletterDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.NewsLetter;
import util.EmailUtil;
import util.ServletUtil;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class NewsLetterService {

    private NewsletterDAO newsletterDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletUtil servletUtil;

    public NewsLetterService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        newsletterDAO = new NewsletterDAO();
        servletUtil = new ServletUtil(request, response);
    }

    public void listNewsletters() throws ServletException, IOException {
        listNewsletters(null);
    }

    public void listNewsletters(String message) throws ServletException, IOException {
        List<NewsLetter> listNewsletters = newsletterDAO.listAll();
        request.setAttribute("listNewsletters", listNewsletters);

        if (message != null) {
            servletUtil.setErrorMessage(message);
        }

        String listPage = "/admin/newsletter/list_newsletter.jsp";
        servletUtil.forwardToPage(listPage);
    }

    public void showNewsletterNewForm() throws ServletException, IOException {
        request.setAttribute("pageTitle", "Create New Newsletter");
        List<NewsLetter> listNewsletters = newsletterDAO.listAll();
        request.setAttribute("listNewsletters", listNewsletters);
        String newPage = "/admin/newsletter/list_newsletter.jsp";
        servletUtil.forwardToPage(newPage);
    }

    public void createNewsletter() throws Exception {
        String email = request.getParameter("email");

        NewsLetter existNewsletter = newsletterDAO.findByEmail(email);

        if (existNewsletter != null) {
            String message = "Không thể tạo liên kết gửi đến '" + email + "' vì đã tồn tại .";
            listNewsletters(message);
            return;
        }

        NewsLetter newNewsletter = new NewsLetter();
        newNewsletter.setEmail(email);
        NewsLetter createdNewsletter = newsletterDAO.create(newNewsletter);

        if (createdNewsletter.getEmail() != null) {
            String message = "Tạo thành công liên kết gửi email. Từ giờ bạn có thể nhận thông báo tin tức mới nhất.";
            listNewsletters(message);
        }
    }

    public void updateNewsletter(boolean enable) throws Exception {
        String email = request.getParameter("id");

        NewsLetter existNewsletter = newsletterDAO.findByEmail(email);

        if (email != null && !existNewsletter.getEmail().equals(email)) {
            String message = "Không thể cập nhật email này. Đã có người đăng ký email này";
            listNewsletters(message);
            return;
        }
        existNewsletter.setEmail(email);
        existNewsletter.setEnabled(enable);
        newsletterDAO.update(existNewsletter);

        String message = "Cập nhật email mới thành công.";
        listNewsletters(message);
    }

    public void sendNewsPost(String postTitle, String postUrl) throws SQLException {
        List<NewsLetter> enabledSubscribers = newsletterDAO.findAllEnabledSubscribers();
        for (NewsLetter subscriber : enabledSubscribers) {
            if (subscriber.isEnabled()) {
                String subject = "Bài viết mới" +  postTitle;
                String body = "Xin chào,\n\nCó một bài viết mới trên trang web của chúng tôi: " + postTitle + "\n\n" +
                        "Bạn có thể đọc bài viết tại đây: " + postUrl + "\n\nCảm ơn bạn đã quan tâm!";
                EmailUtil.sendEmail(subscriber.getEmail(), subject, body);
            }
        }
    }
}
