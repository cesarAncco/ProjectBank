package com.nttdata.project.client.domain.service.impl;

import com.nttdata.project.client.domain.dto.model.Client;
import com.nttdata.project.client.domain.repository.ClientRepository;
import com.nttdata.project.client.domain.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClientServiceImpl.class in this class we are going to implement all the methods of the interface.
 * @Service: we indicate that this class will be a service
 * We use the ClientRepository interface to use its methods in the service
 */

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> allClients() {
        return clientRepository.allClients();
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.saveClient(client);
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.updateClient(client);
    }

    @Override
    public Client deleteClient(Long id) {
        return clientRepository.deleteClient(id);
    }
}
