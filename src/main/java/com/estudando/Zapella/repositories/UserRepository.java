package com.estudando.Zapella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudando.Zapella.entitites.User;



public interface UserRepository extends JpaRepository<User,Long> {

    
    
}
