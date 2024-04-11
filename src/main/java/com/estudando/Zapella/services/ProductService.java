package com.estudando.Zapella.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudando.Zapella.entitites.Order;
import com.estudando.Zapella.entitites.Product;
import com.estudando.Zapella.repositories.OrderRepository;
import com.estudando.Zapella.repositories.ProductRepository;

@Service
public class ProductService {
    

    private final ProductRepository productRepository;

    
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> order = productRepository.findById(id);
        return order.get();
    }

    
}
