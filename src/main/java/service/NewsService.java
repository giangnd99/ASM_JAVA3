package service;

import dao.impl.CategoryDAO;
import dao.impl.NewsDAO;
import dao.impl.UserDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Category;
import model.News;
import model.Users;
import util.XImage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@MultipartConfig
public class NewsService {

    private NewsDAO newsDAO;
    private CategoryDAO categoryDAO;
    private UserDAO userDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;

    private  NewsLetterService newsLetterService;
    public NewsService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        newsDAO = new NewsDAO();
        categoryDAO = new CategoryDAO();
        userDAO = new UserDAO();
        newsLetterService = new NewsLetterService(request, response);

    }

    public void listNews() throws Exception {
        listNews(null);
    }

    public void homePage() throws Exception {
        homePage(null);
    }

    public void listNews(String message) throws Exception {
        List<News> listNews = newsDAO.listAll();
        List<Users> listUser = userDAO.findAll();
        request.setAttribute("listNews", listNews);
        request.setAttribute("listUser", listUser);

        if (message != null) {
            request.setAttribute("message", message);
        }

        String listPage = "/admin/news/list_news.jsp";
        request.getRequestDispatcher(listPage).forward(request, response);
    }

    public void homePage(String message) throws Exception {
        List<News> listNews = newsDAO.listAll();
        List<Users> listUser = userDAO.findAll();
        List<Category> listCategory = categoryDAO.listAll();
        request.setAttribute("listNews", listNews);
        request.setAttribute("listUser", listUser);
        request.setAttribute("listCategory", listCategory);
        getTop5Viewcount();
        getTop5LatestNews();
        String newsIdParam = request.getParameter("id");
        if (newsIdParam != null && !newsIdParam.isEmpty()) {
            viewNewsDetail();
            return;
        }
        if (message != null) {
            request.setAttribute("message", message);
        }
        String listPage = "/index.jsp";
        request.getRequestDispatcher(listPage).forward(request, response);
    }

    public void showNewsNewForm() throws Exception {
        List<Category> listCategory = categoryDAO.listAll();
        List<Users> listUser = userDAO.findAll();
        News news = null;
        request.setAttribute("news", news);
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("listUser", listUser);
        request.setAttribute("pageTitle", "Create New News");

        String newPage = "/admin/news/create_news.jsp";
        request.getRequestDispatcher(newPage).forward(request, response);
    }

    public void createNews() throws Exception {
        String title = request.getParameter("title");
        News existNews = newsDAO.findByTitle(title);

        if (existNews != null) {
            String message = "Không thể tạo tin tức với tiêu đề "
                    + title + "' đã có.";
            listNews(message);
            return;
        }

        News newNews = new News();
        readNewsFields(newNews);

        News createdNews = newsDAO.create(newNews);

        if (createdNews.getId() > 0) {
            String message = "Tin tức rất hay đã được đăng lên thành công.";
            String articleUrl = "http://localhost:8083/Assigment_1_PS37973_war_exploded/news-detail?id=" + createdNews.getId();
            newsLetterService.sendNewsPost(title,articleUrl);
            listNews(message);
        }
    }

    public void readNewsFields(News news) throws ServletException, IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date postedDate;

        try {
            postedDate = dateFormat.parse(request.getParameter("postedDate"));
        } catch (ParseException ex) {
            ex.printStackTrace();
            throw new ServletException("Lỗi không thể chuyển định dạng ngày (phải viết yyyy-MM-dd)");
        }

        news.setTitle(title);
        news.setContent(content);
        news.setPostedDate(postedDate);

        Integer categoryId = Integer.parseInt(request.getParameter("category_id"));
        Category category = categoryDAO.get(categoryId);
        news.setCategoryId(category.getId());

        int authorId = Integer.parseInt(request.getParameter("author"));
        news.setAuthor(authorId);

        // Xử lý ảnh, nếu cần
        File fileSaveDir = new File(request.getServletContext().getRealPath("/newsImages"));
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        Part part = request.getPart("image");
        String fileName = part.getSubmittedFileName();
        if (fileName != null && !fileName.isEmpty()) {
            XImage.saveFile(part, fileSaveDir.getAbsolutePath());
            news.setImage(fileName);
        }
    }

    public void editNews() throws Exception {
        Integer newsId = Integer.parseInt(request.getParameter("id"));
        News news = newsDAO.get(newsId);
        List<Category> listCategory = categoryDAO.listAll();
        List<Users> listUser = userDAO.findAll();

        request.setAttribute("news", news);
        request.setAttribute("listUser", listUser);
        request.setAttribute("listCategory", listCategory);

        String editPage = "/admin/news/update_news.jsp";
        request.getRequestDispatcher(editPage).forward(request, response);
    }

    public void updateNews() throws Exception {
        int newsId = Integer.parseInt(request.getParameter("newsId"));
        String title = request.getParameter("title");

        News existNews = newsDAO.get(newsId);
        News newsByTitle = newsDAO.findByTitle(title);

        if (newsByTitle == null && existNews.equals(newsByTitle)) {
            String message = "Không thể cập nhật tin này! tin này chưa từng có trên trang đọc quyền của mình.";
            listNews(message);
            return;
        }
        readNewsFields(existNews);
        newsDAO.update(existNews);
        String message = "Tin tức của bạn đã được cập nhật lên trang web! Cảm ơn bạn.";
        listNews(message);
    }

    public void deleteNews() throws Exception {
        Integer newsId = Integer.parseInt(request.getParameter("id"));
        newsDAO.remove(newsId);

        String message = "Tin tức này đã được gỡ xuống.";
        listNews(message);
    }

    public void viewNewsDetail() throws ServletException, IOException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Integer newsId = Integer.parseInt(request.getParameter("id"));
        News news = newsDAO.get(newsId);
        request.setAttribute("news", news);
        news.setViewCount(news.getViewCount() + 1); // Tăng số lần xem
        getRelatedNewsList();
        String detailPage = "/frontend/news/news_detail.jsp";
        request.getRequestDispatcher(detailPage).forward(request, response);
    }

    public void search() throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<News> resultNews = searchNewsByKeyword(keyword); // Tìm kiếm tin tức theo từ khóa
        List<Category> resultCategories = searchCategoriesByKeyword(keyword); // Tìm kiếm danh mục theo từ khóa

        request.setAttribute("keyword", keyword);
        request.setAttribute("resultNews", resultNews);
        request.setAttribute("resultCategories", resultCategories);

        String resultPage = "frontend/search_result.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(resultPage);
        requestDispatcher.forward(request, response);
    }

    public List<Category> searchCategoriesByKeyword(String keyword) {
        List<Category> allCategories = categoryDAO.listAll(); // Lấy tất cả danh mục
        List<Category> matchedCategories = new ArrayList<>(); // Danh sách chứa danh mục khớp với từ khóa

        if (keyword != null && !keyword.isEmpty()) {
            String lowerCaseKeyword = keyword.toLowerCase(); // Chuyển đổi từ khóa thành chữ thường

            for (Category category : allCategories) {
                // Kiểm tra xem tên danh mục có chứa từ khóa không
                if (category.getName().toLowerCase().contains(lowerCaseKeyword)) {
                    matchedCategories.add(category);
                }
            }
        }

        return matchedCategories; // Trả về danh sách danh mục khớp với từ khóa
    }

    public List<News> searchNewsByKeyword(String keyword) {
        List<News> allNews = newsDAO.listAll(); // Lấy tất cả tin tức
        List<News> matchedNews = new ArrayList<>(); // Danh sách chứa tin tức khớp với từ khóa

        if (keyword != null && !keyword.isEmpty()) {
            String lowerCaseKeyword = keyword.toLowerCase(); // Chuyển đổi từ khóa thành chữ thường

            for (News news : allNews) {
                // Kiểm tra xem tiêu đề hoặc nội dung tin tức có chứa từ khóa không
                if (news.getTitle().toLowerCase().contains(lowerCaseKeyword)
                        || news.getContent().toLowerCase().contains(lowerCaseKeyword)) {
                    matchedNews.add(news);
                }
            }
        }

        return matchedNews; // Trả về danh sách tin tức khớp với từ khóa
    }

    public void getTop5LatestNews() throws ServletException, IOException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<News> latestNews = newsDAO.findTop5Latest();
        request.setAttribute("latestNews", latestNews);

    }

    public void getTop5Viewcount() throws ServletException, IOException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<News> listTop5viewCount = newsDAO.findTop5MostViewed();
        request.setAttribute("listTop5viewCount", listTop5viewCount);
    }
    public void getRelatedNewsList() throws ServletException, IOException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Integer newsId = Integer.parseInt(request.getParameter("id"));
        News news = newsDAO.get(newsId);
        List<News> relatedNewsList = newsDAO.findByCategory(news.getCategoryId());
        request.setAttribute("relatedNewsList", relatedNewsList);
    }
}