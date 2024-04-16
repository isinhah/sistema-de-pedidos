package com.dev.spring.services;

import com.dev.spring.domain.Order;
import com.dev.spring.exceptions.ObjectNotFoundException;
import com.dev.spring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;

    public Order find(Integer id) {
        Optional<Order> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Order.class.getName()));
    }
}