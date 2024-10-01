package dao;

import model.Users;

import java.util.List;

public interface UserDao {
    void createUser(Users user);

    // Read a user by ID
    Users getUserById(String id);

    // Read a user by email
    Users getUserByEmail(String email);

    // Update an existing user
    void updateUser(Users user);

    // Delete a user by ID
    void deleteUser(String id);

    // Get all users
    List<Users> getAllUsers();

    // Check if user exists by email
    boolean userExistsByEmail(String email);

    void updatePassword(String password);
}