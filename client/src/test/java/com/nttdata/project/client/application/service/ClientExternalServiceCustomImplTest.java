package com.nttdata.project.client.application.service;

import com.nttdata.project.client.application.service.impl.ClientExternalServiceCustomImpl;
import com.nttdata.project.client.domain.dto.model.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.nttdata.project.client.util.util.createClientList;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.nttdata.project.client.util.util.createClient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientExternalServiceCustomImplTest {

    @InjectMocks
    private ClientExternalServiceCustomImpl clientExternalServiceCustom;

    @Mock
    private ClientExternalService clientExternalService;

    @BeforeEach
    void setUp() {
        clientExternalServiceCustom = new ClientExternalServiceCustomImpl(clientExternalService);
    }

    @Test
    void saveClientTest() {
        when(clientExternalService.saveClient(any())).thenReturn(createClient());
        Client test = clientExternalServiceCustom.saveClient(createClient());
        assertEquals("Cesar", test.getName());
        assertEquals("Ancco", test.getLastName());
        assertEquals("1", test.getTypeDocument());
        assertEquals("12345678", test.getDocument());
        assertEquals("1", test.getTypeClient());
    }

    @Test
    void allClientsTest() {
        when(clientExternalService.allClients()).thenReturn(createClientList());
        List<Client> test = clientExternalServiceCustom.allClients();
        assertEquals("Cesar", test.get(0).getName());
        assertEquals("Ancco", test.get(0).getLastName());
        assertEquals("1", test.get(0).getTypeDocument());
        assertEquals("12345678", test.get(0).getDocument());
        assertEquals("1", test.get(0).getTypeClient());

    }

    @Test
    void updateClientTest() {
        when(clientExternalService.updateClient(any())).thenReturn(createClient());
        Client test = clientExternalServiceCustom.updateClient(createClient());
        assertEquals("Cesar", test.getName());
        assertEquals("Ancco", test.getLastName());
        assertEquals("1", test.getTypeDocument());
        assertEquals("12345678", test.getDocument());
        assertEquals("1", test.getTypeClient());
    }

    @Test
    void deleteClientTest() {
        when(clientExternalService.deleteClient(any())).thenReturn(createClient());
        Client test = clientExternalServiceCustom.deleteClient(createClient().getId());
        assertEquals(1L, test.getId());
    }

}
