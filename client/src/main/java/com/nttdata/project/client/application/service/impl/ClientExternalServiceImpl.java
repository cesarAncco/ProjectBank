package com.nttdata.project.client.application.service.impl;

import com.nttdata.project.client.application.service.ClientExternalService;
import com.nttdata.project.client.domain.dto.model.Client;
import com.nttdata.project.client.domain.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientExternalServiceImpl implements ClientExternalService {

    private final ClientService clientService;

    @Override
    public List<Client> allClients() {
        return clientService.allClients();
    }

    @Override
    public Client saveClient(Client client) {
        return clientService.saveClient(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientService.updateClient(client);
    }

    @Override
    public Client deleteClient(Long id) {
        return clientService.deleteClient(id);
    }
}
