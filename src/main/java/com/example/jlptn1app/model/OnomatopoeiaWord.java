package com.example.jlptn1app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OnomatopoeiaWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String onomatopoeia;
    private String translation;
    public OnomatopoeiaWord() {
    }
    public Integer getId() {
        return id;
    }
    public String getOnomatopoeia() {
        return onomatopoeia;
    }
    public void setOnomatopoeia(String onomatopoeia) {
        this.onomatopoeia = onomatopoeia;
    }
    public String getTranslation() {
        return translation;
    }
    public void setTranslation(String translation) {
        this.translation = translation;
    }
}