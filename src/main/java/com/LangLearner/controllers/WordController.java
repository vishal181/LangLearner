package com.LangLearner.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LangLearner.entities.Word;
import com.LangLearner.services.WordService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/words")
public class WordController {

    @Autowired
     private WordService wordService;

    @GetMapping
    public List<Word> getAllWords() {
        return wordService.getAllWords();
    }

    @PostMapping
    public Word addWord(@RequestBody Word word) {
        return wordService.addWord(word);
    }
}




    
    

