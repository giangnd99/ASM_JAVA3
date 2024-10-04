package service;

import dao.impl.CategoryDAO;
import dao.impl.NewsDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Category;
import model.News;
import util.ServletUtil;
import util.XImage;

import java.io.File;
import java.io.IOException;
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
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletUtil servletUtil;

    public NewsService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        newsDAO = new NewsDAO();
        categoryDAO = new CategoryDAO();
        servletUtil = new ServletUtil(request, response);
    }

    public void listNews() throws ServletException, IOException {
        listNews(null);
    }

    public void listNews(String message) throws ServletException, IOException {
        List<News> listNews = newsDAO.listAll();
        request.setAttribute("listNews", listNews);

        if (message != null) {
            servletUtil.setErrorMessage(message);
        }

        String listPage = "news_list.jsp";
        servletUtil.forwardToPage(listPage);
    }

    public void showNewsNewForm() throws ServletException, IOException {
        List<Category> listCategory = categoryDAO.listAll();
        request.setAttribute("listCategory", listCategory);
        request.setAttribute("pageTitle", "Create New News");

        String newPage = "news_form.jsp";
        servletUtil.forwardToPage(newPage);
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

        Integer categoryId = Integer.parseInt(request.getParameter("category"));
        Category category = categoryDAO.get(categoryId);
        news.setCategoryId(category.getId());

        // Xử lý ảnh, nếu cần
        File fileSaveDir = new File(request.getServletContext().getRealPath("/newsImages"));
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        Part part = request.getPart("newsImage");
        String fileName = part.getSubmittedFileName();
        if (fileName != null && !fileName.isEmpty()) {
            XImage.saveFile(part, fileSaveDir.getAbsolutePath());
            news.setImage(fileName);
        }
    }

    public void editNews() throws ServletException, IOException {
        Integer newsId = Integer.parseInt(request.getParameter("id"));
        News news = newsDAO.get(newsId);
        List<Category> listCategory = categoryDAO.listAll();

        request.setAttribute("news", news);
        request.setAttribute("listCategory", listCategory);

        String editPage = "news_form.jsp";
        servletUtil.forwardToPage(editPage);
    }

    public void updateNews() throws Exception {
        String id = request.getParameter("newsId");
        Integer newsId = Integer.valueOf(id);
        String title = request.getParameter("title");

        News existNews = newsDAO.get(newsId);
        News newsByTitle = newsDAO.findByTitle(title);

        if (newsByTitle != null && !existNews.equals(newsByTitle)) {
            String message = "Không thể cập nhật tin này! bạn hãy chọn tiêu đề đọc quyền của mình.";
            listNews(message);
            return;
        }

        readNewsFields(existNews);
        newsDAO.update(existNews);

        String message = "Tin tức của bạn đã được xuất bản lên trang web! Cảm ơn bạn.";
        listNews(message);
    }

    public void deleteNews() throws ServletException, IOException {
        Integer newsId = Integer.parseInt(request.getParameter("id"));
        newsDAO.remove(newsId);

        String message = "Tin tức này đã được gỡ xuống.";
        listNews(message);
    }

    public void viewNewsDetail() throws ServletException, IOException {
        Integer newsId = Integer.parseInt(request.getParameter("id"));
        News news = newsDAO.get(newsId);

        request.setAttribute("news", news);

        String detailPage = "frontend/news_detail.jsp";
        servletUtil.forwardToPage(detailPage);
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
}

