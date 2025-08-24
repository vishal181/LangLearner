package com.LangLearner.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.LangLearner.entities.Word;
import com.LangLearner.services.WordService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/words")
public class WordController {

    @Autowired
    private WordService wordService;

    // Get all words
    @GetMapping
    public List<Word> getAllWords() {
        return wordService.getAllWords();
    }

    // Add a new word
    @PostMapping
    public ResponseEntity<?> addWord(@RequestBody Word word) {
        try {
            Word savedWord = wordService.addWord(word);
            return ResponseEntity.ok(savedWord);
        } catch (IllegalArgumentException e) {
            // Friendly error instead of 500
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error saving word: " + e.getMessage());
        }
    }

    // Get words by category
    @GetMapping("/category/{categoryName}")
    public List<Word> getWordsByCategoryName(@PathVariable String categoryName) {
        return wordService.getWordsByCategoryName(categoryName);
    }
}
