package com.LangLearner.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LangLearner.entities.Word;

public interface WordRepo extends JpaRepository<Word,Long>{

    List<Word> findByCategory(String category);

    
} 
    

