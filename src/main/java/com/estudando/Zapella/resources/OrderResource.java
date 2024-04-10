package com.estudando.Zapella.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudando.Zapella.entitites.Order;
import com.estudando.Zapella.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    
    private final OrderService OrderService;


    @Autowired
    public OrderResource(OrderService OrderService) {
        this.OrderService = OrderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> list = OrderService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(OrderService.findById(id));
    }
}
