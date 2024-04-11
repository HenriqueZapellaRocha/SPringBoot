package com.estudando.Zapella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudando.Zapella.entitites.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    
} 