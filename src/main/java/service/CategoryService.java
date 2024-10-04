package service;

import dao.impl.CategoryDAO;
import dao.impl.NewsDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.News;
import util.ServletUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryService {
    private CategoryDAO categoryDAO;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletUtil servletUtil;

    public CategoryService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        categoryDAO = new CategoryDAO();
        this.servletUtil = new ServletUtil(request, response);
    }

    public void listCategory(String message) throws ServletException, IOException {
        List<Category> listCategory = categoryDAO.listAll();

        request.setAttribute("listCategory", listCategory);

        if (message != null) {
            servletUtil.setErrorMessage(message);
        }

        String listPage = "category_list.jsp";
        servletUtil.forwardToPage(listPage);
    }

    public void listCategory() throws ServletException, IOException {
        listCategory(null);
    }

    public void createCategory() throws ServletException, IOException {
        String name = request.getParameter("name");
        Category existCategory = categoryDAO.findByName(name);

        if (existCategory != null) {
            String message = "Không thể tạo danh mục."
                    + "Đã có danh mục " + name + " rồi.";
            servletUtil.setErrorMessage(message);

            servletUtil.forwardToPage("message.jsp");
        } else {
            Category newCategory = new Category(name);
            categoryDAO.create(newCategory);
            String message = "Tạo thành công danh mục.";
            listCategory(message);
        }
    }

    public void editCategory() throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        Category category = categoryDAO.get(categoryId);
        request.setAttribute("category", category);

        String editPage = "category_form.jsp";
        servletUtil.forwardToPage(editPage);

    }

    public void updateCategory() throws ServletException, IOException {
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String categoryName = request.getParameter("name");

        Category categoryById = categoryDAO.get(categoryId);
        Category categoryByName = categoryDAO.findByName(categoryName);

        if (categoryByName != null && categoryById.getId() != categoryByName.getId()) {
            String message = "Không thể cập nhật danh mục."
                    + " Danh mục " + categoryName + " đã có rồi.";

            servletUtil.setErrorMessage(message);
            servletUtil.forwardToPage("message.jsp");
        } else {
            categoryById.setName(categoryName);
            categoryDAO.update(categoryById);
            String message = "Tạo thành công danh mục";
            listCategory(message);
        }
    }

    public void deleteCategory() throws Exception {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        NewsDAO newsDAO = new NewsDAO();
        List<News> listNews = newsDAO.listAll();
        Map<Integer, List<News>> newsMapByCatgory = new HashMap<Integer, List<News>>();

        for (News news : listNews) {
            int categoryIdByNews = news.getCategoryId();
            newsMapByCatgory.computeIfAbsent(categoryIdByNews, k -> new ArrayList<>()).add(news);
        }
        long numberOfNews = newsMapByCatgory.size();
        String message;

        if (numberOfNews > 0) {
            message = "Không thể xóa danh mục (ID: %d) vì chưa nhiều tin tức hay trong này.";
            message = String.format(message, numberOfNews);
        } else {
            categoryDAO.delete(categoryId);
            message = "Danh mục ID " + categoryId + " đã được xóa thành công.";
        }
        listCategory(message);
    }

}

