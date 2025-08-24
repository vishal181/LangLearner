package com.LangLearner.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String englishWord;  // matches JSON field "englishWord"

    @Column(nullable = false)
    private String spanishWord;  // matches JSON field "spanishWord"

    // Many words belong to one category
    @ManyToOne
    @JoinColumn(name = "category_name", referencedColumnName = "name")
    private Category category;

    // Many words belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Word() {}

    public Word(String englishWord, String spanishWord, User user, Category category) {
        this.englishWord = englishWord;
        this.spanishWord = spanishWord;
        this.user = user;
        this.category = category;
    }

    // Getters & setters
    public Long getId() { return id; }

    public String getEnglishWord() { return englishWord; }
    public void setEnglishWord(String englishWord) { this.englishWord = englishWord; }

    public String getSpanishWord() { return spanishWord; }
    public void setSpanishWord(String spanishWord) { this.spanishWord = spanishWord; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
