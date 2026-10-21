package com.example.jlptn1app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SynonymWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String word;
    private String wordHiragana;
    private String wordTranslation;
    private String synonym;
    private String synonymHiragana;
    private String synonymTranslation;
    public SynonymWord() {
    }
    public Integer getId() {
        return id;
    }
    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public String getWordHiragana() {
        return wordHiragana;
    }
    public void setWordHiragana(String wordHiragana) {
        this.wordHiragana = wordHiragana;
    }
    public String getWordTranslation() {
        return wordTranslation;
    }
    public void setWordTranslation(String wordTranslation) {
        this.wordTranslation = wordTranslation;
    }
    public String getSynonym() {
        return synonym;
    }
    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }
    public String getSynonymHiragana() {
        return synonymHiragana;
    }
    public void setSynonymHiragana(String synonymHiragana) {
        this.synonymHiragana = synonymHiragana;
    }
    public String getSynonymTranslation() {
        return synonymTranslation;
    }
    public void setSynonymTranslation(String synonymTranslation) {
        this.synonymTranslation = synonymTranslation;
    }
}