package com.Project.LibraryManagement.Service;

import com.Project.LibraryManagement.Entity.Category;
import com.Project.LibraryManagement.Repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.getAll();
    }

    public Category getCategoryById(int id) {
        return categoryRepository.getById(id);
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.update(category);
    }

    public void deleteCategory(int id) {
        categoryRepository.delete(id);
    }
}
