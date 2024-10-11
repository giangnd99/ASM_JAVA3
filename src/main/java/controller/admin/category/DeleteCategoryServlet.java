package controller.admin.category;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CategoryService;

@WebServlet("/admin/delete_category")
public class DeleteCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        CategoryService categoryService = new CategoryService(req, resp);
        try {
            categoryService.deleteCategory();
        } catch (Exception e) {
            throw new RuntimeException("Erro when delete category" + e, e.getCause());
        }
    }
}
