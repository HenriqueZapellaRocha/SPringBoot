package com.estudando.Zapella.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudando.Zapella.entitites.Order;




@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    
    
}
