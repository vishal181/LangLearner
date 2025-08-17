package com.LangLearner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LangLearner.entities.Word;

public interface WordRepo extends JpaRepository<Word,Long>{

    
} 
    

