package com.estudando.Zapella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudando.Zapella.entitites.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}
