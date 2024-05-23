package com.nttdata.project.client.application.service.impl;

import com.nttdata.project.client.application.service.ClientExternalService;
import com.nttdata.project.client.application.service.ClientExternalServiceCustom;
import com.nttdata.project.client.domain.dto.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientExternalServiceCustomImpl implements ClientExternalServiceCustom {

    private final ClientExternalService clientExternalService;


    @Override
    public List<Client> allClients() {
        return clientExternalService.allClients();
    }

    @Override
    public Client saveClient(Client client) {
        return clientExternalService.saveClient(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientExternalService.updateClient(client);
    }

    @Override
    public Client deleteClient(Long id) {
        return clientExternalService.deleteClient(id);
    }
}
