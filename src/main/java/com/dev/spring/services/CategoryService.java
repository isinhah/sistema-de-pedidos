package com.dev.spring.services;

import com.dev.spring.domain.Category;
import com.dev.spring.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repo;

    public Category findById(Integer id) {
        Optional<Category> obj = repo.findById(id);
        return obj.orElse(null);
    }
}