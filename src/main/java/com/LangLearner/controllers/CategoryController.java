package com.LangLearner.controllers;

import com.LangLearner.entities.Category;
import com.LangLearner.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // ✅ Get all categories
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // ✅ Add category
    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    // ✅ Get category by name
    @GetMapping("/{name}")
    public Category getCategoryByName(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
    }
}
