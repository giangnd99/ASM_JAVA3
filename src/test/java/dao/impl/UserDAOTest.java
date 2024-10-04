package dao.impl;

import dao.InterfaceDAO;
import model.Users;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private UserDAO userDAO;
    private List<Users> userList; // Giả lập cơ sở dữ liệu

    @BeforeEach
    void setUp() {
        userList = new ArrayList<>();
        userDAO = new UserDAO(); // Giả lập UserDAO với danh sách
    }

    @Test
    void testCreateUser() {
        Users user = new Users();
        user.setFullname("Test User");
        user.setPassword("password123");
        user.setEmail("test@example.com");
        user.setPhone("1234567890");
        user.setBirthday(new Date());
        user.setGender(true); // Nam
        user.setRole(false);   // Người dùng thông thường

        Users createdUser = userDAO.create(user);
        assertNotNull(createdUser);
        assertEquals("Test User", createdUser.getFullname());
        assertEquals(6, createdUser.getId()); // Giả định ID tự động tăng
    }

    @Test
    void testUpdateUser() {
        Users user = new Users();
        user.setFullname("Test User");
        user.setPassword("password123");
        user.setEmail("tesasst@example.com");
        user.setPhone("1234567890");
        user.setBirthday(new Date());
        user.setGender(true);
        user.setRole(false);
        Users createdUser = userDAO.create(user);

        createdUser.setFullname("Updated User");
        Users updatedUser = userDAO.update(createdUser);
        assertNotNull(updatedUser);
        assertEquals("Updated User", updatedUser.getFullname());
    }

    @Test
    void testGetUser() {
        Users user = new Users();
        user.setFullname("Test User");
        user.setPassword("password123");
        user.setEmail("test@example.com");
        user.setPhone("1234567890");
        user.setBirthday(new Date());
        user.setGender(true);
        user.setRole(false);
        Users createdUser = userDAO.create(user);

        Users foundUser = userDAO.get(createdUser.getId());
        assertNotNull(foundUser);
        assertEquals(createdUser.getId(), foundUser.getId());
        assertEquals("Test User", foundUser.getFullname());
    }

    @Test
    void testDeleteUser() {
        Users user = new Users();
        user.setFullname("Test User");
        user.setPassword("password123");
        user.setEmail("test@example.com");
        user.setPhone("1234567890");
        user.setBirthday(new Date());
        user.setGender(true);
        user.setRole(false);
        Users createdUser = userDAO.create(user);

        userDAO.remove(createdUser.getId());
        Users foundUser = userDAO.get(createdUser.getId());
        assertNull(foundUser); // Kiểm tra xem người dùng đã bị xóa
    }

    @Test
    void testListAllUsers() {
        Users user1 = new Users();
        user1.setId(1);
        user1.setFullname("User 1");
        user1.setPassword("password1");
        user1.setEmail("user1@example.com");
        user1.setPhone("1111111111");
        user1.setBirthday(new Date());
        user1.setGender(true);
        user1.setRole(false);

        Users user2 = new Users();
        user2.setId(2);
        user2.setFullname("User 2");
        user2.setPassword("password2");
        user2.setEmail("user2@example.com");
        user2.setPhone("2222222222");
        user2.setBirthday(new Date());
        user2.setGender(false);
        user2.setRole(true);

        userDAO.create(user1);
        userDAO.create(user2);

        List<Users> allUsers = userDAO.listAll();
        assertNotNull(allUsers);
        assertEquals(2, allUsers.size());
        assertEquals("User 1", allUsers.get(0).getFullname());
        assertEquals("User 2", allUsers.get(1).getFullname());
    }
}