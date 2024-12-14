package com.justintime.jit.service;

import com.justintime.jit.entity.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService extends BaseService<Category,Long>{
    List<Category> getAllCategories();
    Category createCategory(Category category);
    Optional<Category> getCategoryById(Long id);
    Category updateCategory(Long id, Category updatedCategory);
    void deleteCategory(Long id);
}
