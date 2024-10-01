package dao;
import ConfigDB.DatabaseConfig;
import model.Categories;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    @Override
    public void create(Categories category) {
        String sql = "INSERT INTO CATEGORIES (Id, Name) VALUES (?, ?)";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getId());
            preparedStatement.setString(2, category.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Categories category) {
        String sql = "UPDATE CATEGORIES SET Id = ? WHERE Name = ?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, category.getId());
            preparedStatement.setString(2, category.getName());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM CATEGORIES WHERE id = ?";
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
    public Categories getCategoryById(String id) {
        String sql = "SELECT * FORM CATEGORIES WHERE id=?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Id") + "  " + resultSet.getString("Name"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Categories> findAll() {
        List<Categories> categories = new ArrayList<>();
        String sql = "SELECT * FROM assignment_java3.categories";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories.add(new Categories(resultSet.getString("Id"), resultSet.getString("Name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}
