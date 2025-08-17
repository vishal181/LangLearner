package com.LangLearner.services;
import java.util.List;

import com.LangLearner.entities.Word;

public interface WordService {
    List<Word> getAllWords();
    Word addWord(Word word);
    List<Word> getWordsByCategory(String category);
}

