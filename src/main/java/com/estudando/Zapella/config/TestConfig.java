package com.estudando.Zapella.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudando.Zapella.entitites.Category;
import com.estudando.Zapella.entitites.Order;
import com.estudando.Zapella.entitites.User;
import com.estudando.Zapella.entitites.enums.OrderStatus;
import com.estudando.Zapella.repositories.CategoryRepository;
import com.estudando.Zapella.repositories.OrderRepository;
import com.estudando.Zapella.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

   
    @Autowired
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        User user1 = new User(null, "Henrique Zapella Rocha", "henri_Zap@Hotmail.com", "999405060", "helloworld");
        User user2 = new User(null, "Pamela Silva", "pamela@gmail.com", "999304070", "AssemblyIsCool");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user1, OrderStatus.WAITING_PAYMENT);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user2, OrderStatus.DELIVERED);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), user1, OrderStatus.PAID);

        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Games");
        Category c3 = new Category(null, "Outfits");

        userRepository.saveAll(Arrays.asList(user1,user2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
    }

    
}
