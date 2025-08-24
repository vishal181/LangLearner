package com.LangLearner.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Word> words = new ArrayList<>();

    public Category() {}
    public Category(String name) { this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Word> getWords() { return words; }
    public void setWords(List<Word> words) { this.words = words; }
}
