package com.dev.spring.resources;

import com.dev.spring.domain.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> listAll() {
        Category category1 = new Category(1, "Informática");
        Category category2 = new Category(2, "Escritório");

        List<Category> list = new ArrayList<>();
        list.add(category1);
        list.add(category2);
        return list;
    }
}