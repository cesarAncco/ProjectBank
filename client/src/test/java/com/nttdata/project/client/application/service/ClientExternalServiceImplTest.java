package com.nttdata.project.client.application.service;

import com.nttdata.project.client.application.service.impl.ClientExternalServiceImpl;
import com.nttdata.project.client.domain.dto.model.Client;
import com.nttdata.project.client.domain.service.ClientService;
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
public class ClientExternalServiceImplTest {

    @InjectMocks
    private ClientExternalServiceImpl clientExternalService;

    @Mock
    private ClientService clientService;

    @BeforeEach
    void setUp() {
        clientExternalService = new ClientExternalServiceImpl(clientService);
    }

    @Test
    void saveClientTest() {
        when(clientService.saveClient(any())).thenReturn(createClient());
        Client test = clientExternalService.saveClient(createClient());
        assertEquals("Cesar", test.getName());
        assertEquals("Ancco", test.getLastName());
        assertEquals("1", test.getTypeDocument());
        assertEquals("12345678", test.getDocument());
        assertEquals("1", test.getTypeClient());
    }

    @Test
    void allClientsTest() {
        when(clientService.allClients()).thenReturn(createClientList());
        List<Client> test = clientExternalService.allClients();
        assertEquals("Cesar", test.get(0).getName());
        assertEquals("Ancco", test.get(0).getLastName());
        assertEquals("1", test.get(0).getTypeDocument());
        assertEquals("12345678", test.get(0).getDocument());
        assertEquals("1", test.get(0).getTypeClient());

    }

    @Test
    void updateClientTest() {
        when(clientService.updateClient(any())).thenReturn(createClient());
        Client test = clientExternalService.updateClient(createClient());
        assertEquals("Cesar", test.getName());
        assertEquals("Ancco", test.getLastName());
        assertEquals("1", test.getTypeDocument());
        assertEquals("12345678", test.getDocument());
        assertEquals("1", test.getTypeClient());
    }

    @Test
    void deleteClientTest() {
        when(clientService.deleteClient(any())).thenReturn(createClient());
        Client test = clientExternalService.deleteClient(createClient().getId());
        assertEquals(1L, test.getId());
    }

}
