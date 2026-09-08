package com.example.jlptn1app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jlptn1app.model.KanjiWord;

public interface KanjiWordRepository extends JpaRepository<KanjiWord, Integer> {

    Page<KanjiWord> findByChapterOrderById(Integer chapter,Pageable pageable);

}