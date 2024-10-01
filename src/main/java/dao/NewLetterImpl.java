package dao;

import ConfigDB.DatabaseConfig;
import model.Newsletters;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class NewLetterImpl implements NewLetterDao {

    @Override
    public void create(Newsletters newsletters) {
        String sql = "insert into newsletters (Email,Enabled) values (?,?)";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newsletters.getEmail());
            preparedStatement.setLong(2, newsletters.getEnabled());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Newsletters newsletters) {
        String sql = "UPDATE newsletters SET enabled =? WHERE id =?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,newsletters.getEmail());
            preparedStatement.setLong(2,newsletters.getEnabled());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void delete(String id) {
        String sql =  "DELETE FROM newsletters WHERE id =?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
