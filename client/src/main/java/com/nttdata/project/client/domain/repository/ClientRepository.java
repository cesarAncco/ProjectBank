package com.nttdata.project.client.domain.repository;

import com.nttdata.project.client.domain.dto.model.Client;

import java.util.List;

public interface ClientRepository {

    List<Client> allClients();
    Client saveClient(Client client);
    Client updateClient(Client client);
    Client deleteClient(Long id);
}
