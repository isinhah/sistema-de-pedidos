package com.dev.spring.controllers;

import com.dev.spring.domain.Client;
import com.dev.spring.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Client obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
