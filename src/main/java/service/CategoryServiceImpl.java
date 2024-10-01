package service;

import dao.CategoryDao;
import lombok.RequiredArgsConstructor;
import model.Categories;
import java.util.List;

@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryDao categoryDao;


    @Override
    public void addCategory(Categories category) {
        categoryDao.create(category);
    }

    @Override
        public void updateCategory(Categories category) {
            categoryDao.update(category);
        }

    @Override
    public void deleteCategory(String id) {
        categoryDao.delete(id);
    }

    @Override
    public Categories getCategoryById(String id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public List<Categories> getAllCategories() {
        return categoryDao.findAll();
    }
}

