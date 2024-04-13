package com.dev.spring.services;

import com.dev.spring.domain.Client;
import com.dev.spring.exceptions.ObjectNotFoundException;
import com.dev.spring.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repo;

    public Client find(Integer id) {
        Optional<Client> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + Client.class.getName()));
    }
}