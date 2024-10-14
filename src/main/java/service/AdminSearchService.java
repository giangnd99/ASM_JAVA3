package service;

import dao.impl.CategoryDAO;
import dao.impl.NewsDAO;
import dao.impl.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
import model.News;
import model.Users;
import util.ServletUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminSearchService {
    private NewsDAO newsDAO;
    private CategoryDAO categoryDAO;
    private UserDAO userDAO; // Khai báo UserDAO
    private ServletUtil servletUtil;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public AdminSearchService(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.newsDAO = new NewsDAO();
        this.categoryDAO = new CategoryDAO();
        this.userDAO = new UserDAO();
        servletUtil = new ServletUtil(request, response);// Khởi tạo UserDAO
    }

    public void search() {
        String keyword = request.getParameter("keyword");
        List<News> newsResult = searchNews(keyword);
        List<Category> categoryResult = searchCategories(keyword);
        List<Users> userResult = searchUsers(keyword);
        List<Users> userByRoleResult = searchUsersByRole(keyword);

        request.setAttribute("newsResult", newsResult);
        request.setAttribute("categoryResult", categoryResult);
        request.setAttribute("userResult", userResult);
        request.setAttribute("userByRoleResult", userByRoleResult);

        String searchPage = "/admin/search_result.jsp";
        try {
            servletUtil.forwardToPage(searchPage);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<News> searchNews(String keyword) {
        List<News> allNews = newsDAO.listAll();
        List<News> matchedNews = new ArrayList<>();

        if (keyword != null && !keyword.isEmpty()) {
            String lowerCaseKeyword = keyword.toLowerCase();

            for (News news : allNews) {
                if (news.getTitle().toLowerCase().contains(lowerCaseKeyword) ||
                        news.getContent().toLowerCase().contains(lowerCaseKeyword)) {
                    matchedNews.add(news);
                }
            }
        }

        return matchedNews;
    }

    public List<Category> searchCategories(String keyword) {
        List<Category> allCategories = categoryDAO.listAll();
        List<Category> matchedCategories = new ArrayList<>();

        if (keyword != null && !keyword.isEmpty()) {
            String lowerCaseKeyword = keyword.toLowerCase();

            for (Category category : allCategories) {
                if (category.getName().toLowerCase().contains(lowerCaseKeyword)) {
                    matchedCategories.add(category);
                }
            }
        }

        return matchedCategories;
    }

    // Phương thức tìm kiếm người dùng
    public List<Users> searchUsers(String keyword) {
        List<Users> allUsers = userDAO.listAll(); // Giả sử có phương thức listAll() trong UserDAO
        List<Users> matchedUsers = new ArrayList<>();

        if (keyword != null && !keyword.isEmpty()) {
            String lowerCaseKeyword = keyword.toLowerCase();

            for (Users user : allUsers) {
                if (user.getFullname().toLowerCase().contains(lowerCaseKeyword) ||
                        user.getEmail().toLowerCase().contains(lowerCaseKeyword)) {
                    matchedUsers.add(user);
                }
            }
        }

        return matchedUsers;
    }

    // Phương thức tìm kiếm theo vai trò
    public List<Users> searchUsersByRole(String keyword) {
        boolean role = false;
        if (keyword.contains("admin")) {
            role = true;
        }

        List<Users> allUsers = userDAO.listAll();
        List<Users> adminUsers = new ArrayList<>();
        List<Users> authorUsers = new ArrayList<>();

        for (Users user : allUsers) {
            if (user.isRole()) {
                adminUsers.add(user);
            } else {
                authorUsers.add(user);
            }
        }

        if (role) {
            return adminUsers;
        }
        return authorUsers;
    }
}
