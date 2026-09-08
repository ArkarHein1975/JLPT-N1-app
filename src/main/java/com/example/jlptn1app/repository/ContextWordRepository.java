package com.example.jlptn1app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jlptn1app.model.ContextWord;

public interface ContextWordRepository extends JpaRepository<ContextWord, Integer> {

    Page<ContextWord> findAllByOrderById(Pageable pageable);

}