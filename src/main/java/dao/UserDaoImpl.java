package dao;

import ConfigDB.DatabaseConfig;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void createUser(Users user) {
        String sql = "INSERT INTO USERS (Id,Password,Fullname,Birthday,Gender,Mobile,Email,Role) VALUES (?,?,?,?,?,?,?,?)";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFullname());
            preparedStatement.setDate(4, user.getBirthday());
            preparedStatement.setLong(5, user.getGender());
            preparedStatement.setString(6, user.getMobile());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setLong(8, user.getRole());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Users getUserById(String id) {
        String sql = "SELECT * FROM assignment_java3.USERS WHERE Id=?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setFullname(resultSet.getString(3));
                user.setBirthday(resultSet.getDate(4));
                user.setGender(resultSet.getLong(5));
                user.setMobile(resultSet.getString(6));
                user.setEmail(resultSet.getString(7));
                user.setRole(resultSet.getLong(8));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Users getUserByEmail(String email) {
        String sql = "SELECT * FROM assignment_java3.USERS WHERE Email=?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setFullname(resultSet.getString(3));
                user.setBirthday(resultSet.getDate(4));
                user.setGender(resultSet.getLong(5));
                user.setMobile(resultSet.getString(6));
                user.setEmail(resultSet.getString(7));
                user.setRole(resultSet.getLong(8));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(Users user) {
        String sql = "UPDATE users SET Fullname =? ,Birthday =?, Gender=?, Mobile=?,Email=?,Role=? WHERE id = ? ";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getFullname());
            preparedStatement.setDate(3, user.getBirthday());
            preparedStatement.setLong(4, user.getGender());
            preparedStatement.setString(5, user.getMobile());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setLong(7, user.getRole());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("User updated successfully.");
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(String id) {
        String sql = "DELETE FROM USERS WHERE Id=?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("User deleted successfully.");
            e.printStackTrace();
        }
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM USERS";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Users user = new Users();
                user.setId(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                user.setFullname(resultSet.getString(3));
                user.setBirthday(resultSet.getDate(4));
                user.setGender(resultSet.getLong(5));
                user.setMobile(resultSet.getString(6));
                user.setEmail(resultSet.getString(7));
                user.setRole(resultSet.getLong(8));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean userExistsByEmail(String email) {
        String sql = "SELECT COUNT(*) FROM USERS WHERE Email=?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt(1) > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updatePassword(String password) {
        String sql = "UPDATE USERS SET Password =? where Id=?";
        try {
            Connection connection = DatabaseConfig.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("Password updated successfully.");
            e.printStackTrace();
        }
    }
}
