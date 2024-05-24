package com.nttdata.project.client.domain.repository;

import com.nttdata.project.client.domain.dto.model.Client;

import java.util.List;

/**
 * ClientRepository: the interface will refer to all the methods that will be implemented
 */

public interface ClientRepository {

    List<Client> allClients();
    Client saveClient(Client client);
    Client updateClient(Client client);
    Client deleteClient(Long id);
}
