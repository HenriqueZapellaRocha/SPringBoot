package com.estudando.Zapella.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudando.Zapella.entitites.User;
import com.estudando.Zapella.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        User user1 = new User(null, "Henrique Zapella Rocha", "henri_Zap@Hotmail.com", "999405060", "helloworld");
        User user2 = new User(null, "Pamela Silva", "pamela@gmail.com", "999304070", "AssemblyIsCool");


        userRepository.saveAll(Arrays.asList(user1,user2));
    }

    
}
