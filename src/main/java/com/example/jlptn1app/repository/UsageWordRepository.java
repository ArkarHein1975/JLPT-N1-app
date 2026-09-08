package com.example.jlptn1app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jlptn1app.model.UsageWord;

public interface UsageWordRepository extends JpaRepository<UsageWord, Integer> {

    Page<UsageWord> findAllByOrderById(Pageable pageable);

}