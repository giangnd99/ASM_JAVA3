package service;

import model.Categories;

import java.util.List;

public interface CategoryService {
    void addCategory(Categories category);
    void updateCategory(Categories category);
    void deleteCategory(String id);
    Categories getCategoryById(String id);
    List<Categories> getAllCategories();
}
