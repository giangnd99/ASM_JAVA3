package dao;

import ConfigDB.DatabaseConfig;
import lombok.RequiredArgsConstructor;
import model.News;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class NewsDaoImpl implements NewsDao {
    @Override
    public void create(News news) {
        String sql = "INSERT INTO NEWS (Id, Title, Content, Image, PostedDate, Author, ViewCount, CategoryId, Home) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, news.getId());
            preparedStatement.setString(2, news.getTitle());
            preparedStatement.setString(3, news.getContent());
            preparedStatement.setString(4, news.getImage());
            preparedStatement.setDate(5, news.getPostedDate());
            preparedStatement.setString(6, news.getAuthor());
            preparedStatement.setLong(7, news.getViewCount());
            preparedStatement.setString(8, news.getCategoryId());
            preparedStatement.setLong(9, news.getHome());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(News news) {
        String sql = "UPDATE NEWS SET Title=?, Content=?, Image=?, PostedDate=?, Author=?, ViewCount=?, CategoryId=?, Home=? WHERE Id=?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, news.getTitle());
            preparedStatement.setString(2, news.getContent());
            preparedStatement.setString(3, news.getImage());
            preparedStatement.setDate(4, news.getPostedDate());
            preparedStatement.setString(5, news.getAuthor());
            preparedStatement.setLong(6, news.getViewCount());
            preparedStatement.setString(7, news.getCategoryId());
            preparedStatement.setLong(8, news.getHome());
            preparedStatement.setString(9, news.getId());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM NEWS WHERE Id=?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public News findByNewsId(String id) {
        String sql = "SELECT * FROM NEWS WHERE Id=?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getString("Id"));
                news.setTitle(resultSet.getString("Title"));
                news.setContent(resultSet.getString("Content"));
                news.setImage(resultSet.getString("Image"));
                news.setPostedDate(resultSet.getDate("PostedDate"));
                news.setAuthor(resultSet.getString("Author"));
                news.setViewCount(resultSet.getLong("ViewCount"));
                news.setCategoryId(resultSet.getString("CategoryId"));
                news.setHome(resultSet.getLong("Home"));
                return news;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<News> getNewsList() {
        List<News> newsList = new ArrayList<>();
        String sql = "SELECT * FORM";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                News news = new News();
                news.setId(resultSet.getString("Id"));
                news.setTitle(resultSet.getString("Title"));
                news.setContent(resultSet.getString("Content"));
                news.setImage(resultSet.getString("Image"));
                news.setPostedDate(resultSet.getDate("PostedDate"));
                news.setAuthor(resultSet.getString("Author"));
                news.setViewCount(resultSet.getLong("ViewCount"));
                news.setCategoryId(resultSet.getString("CategoryId"));
                news.setHome(resultSet.getLong("Home"));
                newsList.add(news);
            }
        }catch (Exception e) {
             e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<News> findByCategory(String categoryId) {
        List<News> newsList = new ArrayList<>();
        String sql = "SELECT * FROM NEWS WHERE CategoryId=?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                News news = new News();
                news.setId(resultSet.getString("Id"));
                news.setTitle(resultSet.getString("Title"));
                news.setContent(resultSet.getString("Content"));
                news.setImage(resultSet.getString("Image"));
                news.setPostedDate(resultSet.getDate("PostedDate"));
                news.setAuthor(resultSet.getString("Author"));
                news.setViewCount(resultSet.getLong("ViewCount"));
                news.setCategoryId(resultSet.getString("CategoryId"));
                news.setHome(resultSet.getLong("Home"));
                newsList.add(news);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<News> findByAuthor(String author) {
        List<News> newsList = new ArrayList<>();
        String sql = "SELECT * FROM NEWS WHERE Author=?";
        try{
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, author);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                News news = new News();
                news.setId(resultSet.getString("Id"));
                news.setTitle(resultSet.getString("Title"));
                news.setContent(resultSet.getString("Content"));
                news.setImage(resultSet.getString("Image"));
                news.setPostedDate(resultSet.getDate("PostedDate"));
                news.setAuthor(resultSet.getString("Author"));
                news.setViewCount(resultSet.getLong("ViewCount"));
                news.setCategoryId(resultSet.getString("CategoryId"));
                news.setHome(resultSet.getLong("Home"));
                newsList.add(news);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
