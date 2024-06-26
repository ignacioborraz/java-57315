package com.abmcoder.abm.services;

import com.abmcoder.abm.entities.Client;
import com.abmcoder.abm.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository repository;

    public void saveClient(Client client) {
        repository.save(client);
    }

    public List<Client> readClients() {
        return repository.findAll();
    }

    public Optional<Client> readOneClient(Long id) {
        //devuelve la clase Client si la encuentra
        //devuelve null si no lo encuentra
        return repository.findById(id);
    }

    public void destroyOneClient(Long id) {
        repository.deleteById(id);
    }

}
