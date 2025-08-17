package com.LangLearner.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LangLearner.entities.Word;
import com.LangLearner.repositories.WordRepo;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    @Autowired
    private WordRepo wordRepository;

    @Override
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }

    @Override
    public Word addWord(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public List<Word> getWordsByCategory(String category) {
        return wordRepository.findByCategory(category);
    }

}
