package dao.impl;

import model.News;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewsDAOTest {

    private NewsDAO newsDAO;
    private CategoryDAO categoryDAO;
    private UserDAO userDAO;

    @BeforeEach
    void setUp() {
        newsDAO = new NewsDAO();
        categoryDAO = new CategoryDAO();
        userDAO = new UserDAO();
    }

    @AfterEach
    void tearDown() {
        // Xóa dữ liệu mẫu nếu cần thiết sau mỗi test
    }

    @Test
    void create() {
        News news = new News();
        news.setTitle("Sample News");
        news.setContent("Sample content");
        news.setImage("sample.jpg");
        news.setPostedDate(java.sql.Date.valueOf("2024-10-03"));
        news.setAuthor(userDAO.get(6).getId());  // Khóa ngoại user
        news.setCategoryId(categoryDAO.get(6).getId());  // Khóa ngoại category
        news.setHome(true);

        News createdNews = newsDAO.create(news);
        assertNotNull(createdNews);
        assertEquals("Sample News", createdNews.getTitle());
    }

    @Test
    void update() {
        News news = newsDAO.get(11);  //
        assertNotNull(news);

        news.setTitle("Updated News");
        News updatedNews = newsDAO.update(news);
        assertNotNull(updatedNews);
        assertEquals("Updated News", updatedNews.getTitle());
    }

    @Test
    void get() {
        News news = newsDAO.get(1);  // Test với id của bản ghi tồn tại
        assertNotNull(news);
        assertEquals(1, news.getId());
    }

    @Test
    void remove() {
        int idToRemove = 11;  // Test với id của bản ghi có thể xóa
        newsDAO.remove(idToRemove);
        assertNull(newsDAO.get(idToRemove));
    }

    @Test
    void listAll() {
        List<News> allNews = newsDAO.listAll();
        assertNotNull(allNews);
        assertFalse(allNews.isEmpty());
    }

    @Test
    void findByCategory() throws Exception {
        List<News> categoryNews = null;  // id category là 6
        categoryNews = newsDAO.findByCategory(1);
        assertNotNull(categoryNews);
        assertFalse(categoryNews.isEmpty());
    }

    @Test
    void findTop5MostViewed() throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<News> topViewedNews = newsDAO.findTop5MostViewed();
        assertNotNull(topViewedNews);
        assertTrue(topViewedNews.size() <= 5);
    }

    @Test
    void findTop5Latest() throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<News> latestNews = newsDAO.findTop5Latest();
        assertNotNull(latestNews);
        assertTrue(latestNews.size() <= 5);
    }

    @Test
    void findTop5RecentlyViewed() throws SQLException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<News> recentlyViewedNews = newsDAO.findTop5RecentlyViewed();
        assertNotNull(recentlyViewedNews);
        assertTrue(recentlyViewedNews.size() <= 5);
    }
}
