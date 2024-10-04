package dao.impl;

import dao.GenericDAO;
import dao.InterfaceDAO;
import model.News;
import util.XJdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NewsDAO extends GenericDAO<News> implements InterfaceDAO<News> {

    @Override
    public News create(News news) {
        try {
            super.insert(news);
            return findByTitle(news.getTitle());  // Trả về bài viết sau khi lưu vào DB
        } catch (Exception e) {
            throw new RuntimeException("Error inserting news", e);
        }
    }

    @Override
    public News update(News news) {
        try {
            if (news.getId() == null) {
                throw new RuntimeException("ID is null");
            }
            return super.update(news, news.getId());
        } catch (Exception e) {
            throw new RuntimeException("Error updating news", e);
        }
    }

    @Override
    public News get(Integer id) {
        try {
            if (id == null) {
                throw new RuntimeException("ID is null");
            }
            return findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error fetching news by id", e);
        }
    }

    @Override
    public boolean remove(Integer id) {
        try {
            // Xóa bài viết theo id
            return super.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error removing news", e);
        }
    }

    @Override
    public List<News> listAll() {
        try {
            // Liệt kê tất cả các bài viết
            return findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching all news", e);
        }
    }

    public News findByTitle(String title) throws Exception {
        String sql = "select * from news where title like ?";
        ResultSet rs = XJdbc.query(sql, title);
        if (rs.next()) {
        return super.mapResultSetToEntity(rs);
        }return null;
    }

    // Find news by category
    public List<News> findByCategory(int categoryId) throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String sql = "SELECT * FROM news WHERE categoryId = ?";
        ResultSet rs = XJdbc.query(sql, categoryId);
        return mapResultSetToEntityList(rs);
    }

    // Find top 5 most viewed news
    public List<News> findTop5MostViewed() throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String sql = "SELECT * FROM news ORDER BY viewCount DESC LIMIT 5";
        ResultSet rs = XJdbc.query(sql);
        return mapResultSetToEntityList(rs);
    }

    // Find top 5 most recent news
    public List<News> findTop5Latest() throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String sql = "SELECT * FROM news ORDER BY postedDate DESC LIMIT 5";
        ResultSet rs = XJdbc.query(sql);
        return mapResultSetToEntityList(rs);
    }

    // Find top 5 most recently viewed news
    public List<News> findTop5RecentlyViewed() throws SQLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String sql = "SELECT * FROM news ORDER BY postedDate DESC LIMIT 5";
        ResultSet rs = XJdbc.query(sql);
        return mapResultSetToEntityList(rs);
    }
}
