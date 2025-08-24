package com.LangLearner.services;

import com.LangLearner.entities.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category getCategoryByName(String name);
}
