package com.nttdata.project.client.domain.service;

import com.nttdata.project.client.domain.dto.model.Client;
import com.nttdata.project.client.domain.repository.ClientRepository;
import com.nttdata.project.client.domain.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.nttdata.project.client.util.util.createClient;
import static com.nttdata.project.client.util.util.createClientList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        clientService = new ClientServiceImpl(clientRepository);
    }

    @Test
    void saveClientTest() {
        when(clientRepository.saveClient(any())).thenReturn(createClient());
        Client test = clientService.saveClient(createClient());
        assertEquals("Cesar", test.getName());
        assertEquals("Ancco", test.getLastName());
        assertEquals("1", test.getTypeDocument());
        assertEquals("12345678", test.getDocument());
        assertEquals("1", test.getTypeClient());
    }

    @Test
    void allClientsTest() {
        when(clientRepository.allClients()).thenReturn(createClientList());
        List<Client> test = clientService.allClients();
        assertEquals("Cesar", test.get(0).getName());
        assertEquals("Ancco", test.get(0).getLastName());
        assertEquals("1", test.get(0).getTypeDocument());
        assertEquals("12345678", test.get(0).getDocument());
        assertEquals("1", test.get(0).getTypeClient());

    }

    @Test
    void updateClientTest() {
        when(clientRepository.updateClient(any())).thenReturn(createClient());
        Client test = clientService.updateClient(createClient());
        assertEquals("Cesar", test.getName());
        assertEquals("Ancco", test.getLastName());
        assertEquals("1", test.getTypeDocument());
        assertEquals("12345678", test.getDocument());
        assertEquals("1", test.getTypeClient());
    }

    @Test
    void deleteClientTest() {
        when(clientRepository.deleteClient(any())).thenReturn(createClient());
        Client test = clientService.deleteClient(createClient().getId());
        assertEquals(1L, test.getId());
    }

}
