package com.LangLearner.repositories;

import com.LangLearner.entities.Word;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findByCategory_Name(String categoryName);
}
