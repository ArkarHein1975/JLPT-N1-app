package com.example.jlptn1app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContextWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String kanji;
    private String targetWord;
    private String hiragana;
    private String translation;
    private String example;
    public ContextWord() {
    }
    public Integer getId() {
        return id;
    }
    public String getKanji() {
        return kanji;
    }
    public void setKanji(String kanji) {
        this.kanji = kanji;
    }
    public String getTargetWord() {
        return targetWord;
    }
    public void setTargetWord(String targetWord) {
        this.targetWord = targetWord;
    }
    public String getHiragana() {
        return hiragana;
    }
    public void setHiragana(String hiragana) {
        this.hiragana = hiragana;
    }
    public String getTranslation() {
        return translation;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }
    public String getExample() {
        return example;
    }
    public void setExample(String example) {
        this.example = example;
    }
}