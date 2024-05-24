package com.nttdata.project.client.application.service;

import com.nttdata.project.client.domain.dto.model.Client;

import java.util.List;

/**
 * In ClientExternalServiceCustom we place functions so that we can later implement them
 */

public interface ClientExternalServiceCustom {
    List<Client> allClients();
    Client saveClient(Client client);
    Client updateClient(Client client);
    Client deleteClient(Long id);
}
