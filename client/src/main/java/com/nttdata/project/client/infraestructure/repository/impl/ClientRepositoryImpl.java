package com.nttdata.project.client.infraestructure.repository.impl;

import com.nttdata.project.client.domain.dto.entity.ClientEntity;
import com.nttdata.project.client.domain.dto.model.Client;
import com.nttdata.project.client.domain.repository.ClientRepository;
import com.nttdata.project.client.infraestructure.mapper.ClientEntityMapper;
import com.nttdata.project.client.infraestructure.repository.dto.ClientRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientRepositoryJPA clientRepositoryJPA;


    @Override
    public List<Client> allClients() {
        return ClientEntityMapper.INSTANCE.mapToClient(clientRepositoryJPA.findAll());
    }

    @Override
    public Client saveClient(Client client) {
        return ClientEntityMapper.INSTANCE.mapToClient(
                clientRepositoryJPA.save(ClientEntityMapper.INSTANCE.mapToClientEntity(client))
        );
    }

    @Override
    public Client updateClient(Client client) {
        ClientEntity clientEntity = clientRepositoryJPA.findById(client.getId())
                .orElseThrow(() -> new NoSuchElementException("Client not found."));
        return ClientEntityMapper.INSTANCE.mapToClient((
                clientRepositoryJPA.save(ClientEntityMapper.INSTANCE.mapToClientEntity(client))
        ));
    }

    @Override
    public Client deleteClient(Long id) {
        ClientEntity clientEntity = clientRepositoryJPA.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Client with id " + id + " not found."));
        clientRepositoryJPA.delete(clientEntity);
        return ClientEntityMapper.INSTANCE.mapToClient(clientEntity);
    }
}
