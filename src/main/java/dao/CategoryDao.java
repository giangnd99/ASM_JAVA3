package dao;


import model.Categories;

import java.util.List;

public interface CategoryDao {
    void create (Categories category);
    void update(Categories category);
    void delete(String id);

    Categories getCategoryById(String id);
    List<Categories> findAll();
}
