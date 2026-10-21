package com.example.jlptn1app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class KanjiWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer chapter;
    private String kanji;
    private String hiragana;
    private String translation;
    public KanjiWord() {
    }
    public Integer getId() {
        return id;
    }
    public Integer getChapter() {
        return chapter;
    }
    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }
    public String getKanji() {
        return kanji;
    }
    public void setKanji(String kanji) {
        this.kanji = kanji;
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
}