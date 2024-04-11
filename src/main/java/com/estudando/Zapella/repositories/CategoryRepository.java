package com.estudando.Zapella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudando.Zapella.entitites.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}
