package com.LangLearner.services;

import com.LangLearner.entities.Word;
import java.util.List;

public interface WordService {
    List<Word> getAllWords();
    Word addWord(Word word);
    List<Word> getWordsByCategoryName(String categoryName);
}
