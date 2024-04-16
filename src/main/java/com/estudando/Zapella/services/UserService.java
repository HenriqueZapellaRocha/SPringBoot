package com.estudando.Zapella.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudando.Zapella.entitites.User;
import com.estudando.Zapella.repositories.UserRepository;

@Service
public class UserService {
    
   
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.get();
    }

    public User insert(User newUser) {

        return repository.save(newUser);
    }
}
