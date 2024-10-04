package dao.impl;

import model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryDAOTest {

    private CategoryDAO categoryDAO;
    private Category testCategory;

    @BeforeEach
    void setUp() {
        categoryDAO = new CategoryDAO();
        // Tạo đối tượng Category với ID 10 để kiểm thử
        testCategory = new Category();
        testCategory.setName("Test Category");
    }

    @Test
    void create() {
        // Test trường hợp thêm mới thành công
        Category createdCategory = categoryDAO.create(testCategory);
        assertNotNull(createdCategory, "The created category should not be null");
        assertEquals(testCategory.getName(), createdCategory.getName(), "The category name should match");
    }

    @Test
    void update() {
        // Test cập nhật thành công
        testCategory.setId(6);
        testCategory.setName("Updated Test Category");
        Category updatedCategory = categoryDAO.update(testCategory);
        assertNotNull(updatedCategory, "The updated category should not be null");
        assertEquals("Updated Test Category", updatedCategory.getName(), "The category name should be updated");
    }

    @Test
    void get() {
        // Test lấy category theo ID
        Category foundCategory = categoryDAO.get(6);
        assertNotNull(foundCategory, "The category should be found");
        assertEquals(6, foundCategory.getId(), "The category ID should be 10");
    }

    @Test
    void remove() {
        // Test xóa category theo ID
        categoryDAO.remove(6);
        Category deletedCategory = categoryDAO.get(6);
        assertNull(deletedCategory, "The category should be null after deletion");
    }

    @Test
    void listAll() {
        // Test lấy tất cả category
        List<Category> categories = categoryDAO.listAll();
        assertNotNull(categories, "The categories list should not be null");
        assertTrue(categories.size() > 0, "The categories list should contain at least one category");
    }
}
