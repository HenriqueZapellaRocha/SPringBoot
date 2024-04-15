package com.estudando.Zapella.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudando.Zapella.entitites.Category;
import com.estudando.Zapella.entitites.Order;
import com.estudando.Zapella.entitites.OrderItem;
import com.estudando.Zapella.entitites.Payment;
import com.estudando.Zapella.entitites.Product;
import com.estudando.Zapella.entitites.User;
import com.estudando.Zapella.entitites.enums.OrderStatus;
import com.estudando.Zapella.repositories.CategoryRepository;
import com.estudando.Zapella.repositories.OrderItemRepository;
import com.estudando.Zapella.repositories.OrderRepository;
import com.estudando.Zapella.repositories.ProductRepository;
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
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;


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
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        userRepository.saveAll(Arrays.asList(user1,user2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);

        

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
        OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
        OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

        Payment pay1 = new Payment(null, Instant.parse("2019-07-22T15:21:22Z"), o3);
        o3.setPayment(pay1);

        orderRepository.save(o3);
    }

    
}
