package com.eNotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eNotes.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {



}
