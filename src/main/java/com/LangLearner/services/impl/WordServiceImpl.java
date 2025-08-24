package com.LangLearner.services.impl;

import com.LangLearner.entities.Category;
import com.LangLearner.entities.User;
import com.LangLearner.entities.Word;
import com.LangLearner.repositories.CategoryRepository;
import com.LangLearner.repositories.UserRepository;
import com.LangLearner.repositories.WordRepository;
import com.LangLearner.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    @Override
    public Word addWord(Word word) {
        // ✅ Check User
        if (word.getUser() == null || word.getUser().getId() == null) {
            throw new IllegalArgumentException("User ID is required to add a word!");
        }

        User user = userRepository.findById(word.getUser().getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + word.getUser().getId()));
        word.setUser(user);
        user.getWords().add(word); // maintain bidirectional

        // ✅ Check Category (auto-create if missing)
        if (word.getCategory() == null || word.getCategory().getName() == null
                || word.getCategory().getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Category name is required to add a word!");
        }

        String categoryName = word.getCategory().getName().trim();
        Category category = categoryRepository.findByNameIgnoreCase(categoryName)
                .orElseGet(() -> {
                    Category newCategory = new Category(categoryName);
                    return categoryRepository.save(newCategory);
                });
        word.setCategory(category);
        category.getWords().add(word); // maintain bidirectional

        // ✅ Save Word
        return wordRepository.save(word);
    }

    @Override
    public List<Word> getWordsByCategoryName(String categoryName) {
        return wordRepository.findByCategory_Name(categoryName);
    }
}
