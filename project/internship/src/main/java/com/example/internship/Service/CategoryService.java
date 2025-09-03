package com.example.internship.Service;

import com.example.internship.Entity.Category;
import com.example.internship.Repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    public CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> getAllCategories() {
        return categoryRepo.getAll();
    }

    public void addCategory(Category category) {
        categoryRepo.insert(category);
    }

    public void deleteCategory(int id) {
        categoryRepo.delete(id);
    }
}
