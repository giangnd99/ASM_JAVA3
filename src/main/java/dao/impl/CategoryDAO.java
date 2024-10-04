package dao.impl;

import dao.GenericDAO;
import dao.InterfaceDAO;
import model.Category;
import util.XJdbc;

import java.sql.ResultSet;
import java.util.List;

public class CategoryDAO extends GenericDAO<Category> implements InterfaceDAO<Category> {

    @Override
    public Category create(Category category) {
        try {
            insert(category);
            return findByName(category.getName());
        } catch (Exception e) {
            throw new RuntimeException("Error while creating category: " + e.getMessage(), e);
        }
    }

    @Override
    public Category update(Category category) {
        if (category.getId() == null) {
            throw new IllegalArgumentException("User ID cannot be null for update.");
        }
        try {
            return super.update(category, category.getId());
        } catch (Exception e) {
            throw new RuntimeException("Error while updating category: " + e.getMessage(), e);
        }
    }

    @Override
    public Category get(Integer id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("User ID cannot be null for read.");
            }
            return super.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error while getting category: " + e.getMessage(), e);
        }

    }

    @Override
    public boolean remove(Integer id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("User ID cannot be null for delete.");
            }
            return super.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Error while removing category: " + e.getMessage(), e);
        }
    }

    public Category findByName(String name) {
        try {
            String sql = "select * from category where name = ?";
            ResultSet resultSet = XJdbc.query(sql, name);
            if (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
                return category;
            } else {
                return null;  // Không tìm thấy Category với tên đã cho
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while getting category: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Category> listAll() {
        try {
            return super.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error while listing all categories: " + e.getMessage(), e);
        }
    }
}
