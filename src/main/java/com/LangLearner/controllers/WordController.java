package com.LangLearner.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LangLearner.entities.Word;
import com.LangLearner.repositories.WordRepo;

@RestController
@RequestMapping("/api/words")
public class WordController {

    @Autowired
    private WordRepo wordRepository;

    @GetMapping
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    @PostMapping
    public Word addWord(@RequestBody Word word) {
        return wordRepository.save(word);
    }
}




    
    

