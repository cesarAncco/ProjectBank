package com.nttdata.project.client.infraestructure.service;

import com.nttdata.project.client.domain.dto.entity.ClientEntity;
import com.nttdata.project.client.infraestructure.repository.dto.ClientRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class ClientServiceImpl implements IClientService {

    /**
    @Autowired
    private ClientRepositoryJPA clientRepository;

    @Override
    public List<ClientEntity> findAll() {
        return (List<ClientEntity>) clientRepository.findAll();
    }

    @Override
    public ClientEntity findById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public void createClient(ClientEntity client) {
        clientRepository.save(client);
    }

    @Override
    public ClientEntity updateClient(ClientEntity client) {
        ClientEntity existingClient = clientRepository.findById(client.getId()).orElseThrow();

        existingClient.setName(client.getName());
        existingClient.setLastName(client.getLastName());
        existingClient.setTypeDocument(client.getTypeDocument());
        existingClient.setDocument(client.getDocument());
        existingClient.setTypeDocument(client.getTypeDocument());

        return clientRepository.save(existingClient);
    }

    @Override
    public ClientEntity deleteClient(Long id) {
        ClientEntity existingClient = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(existingClient);
        return existingClient;
    }

    @Override
    public ClientEntity findByDocument(String document) {
        return clientRepository.findByDocument(document);
    }**/
}
