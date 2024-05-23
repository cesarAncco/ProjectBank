package com.nttdata.project.client.infrastructure.repository;

import com.nttdata.project.client.domain.dto.model.Client;
import com.nttdata.project.client.infraestructure.repository.dto.ClientRepositoryJPA;
import com.nttdata.project.client.infraestructure.repository.impl.ClientRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.nttdata.project.client.util.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientRepositoryTest {

    @InjectMocks
    private ClientRepositoryImpl clientRepository;

    @Mock
    private ClientRepositoryJPA clientRepositoryJPA;

    @BeforeEach
    void setUp() {
        clientRepository = new ClientRepositoryImpl(clientRepositoryJPA);
    }

    @Test
    void saveClientTest() {
        when(clientRepositoryJPA.save(any())).thenReturn(createClientEntity());
        Client test = clientRepository.saveClient(createClient());
        assertEquals("Cesar", test.getName());
        assertEquals("Ancco", test.getLastName());
        assertEquals("DNI", test.getTypeDocument());
        assertEquals("12345678", test.getDocument());
        assertEquals("PERSONAL", test.getTypeClient());
    }

    @Test
    void allClientsTest() {
        when(clientRepositoryJPA.findAll()).thenReturn(createClientEntityList());
        List<Client> test = clientRepository.allClients();
        assertEquals("Cesar", test.get(0).getName());
        assertEquals("Ancco", test.get(0).getLastName());
        assertEquals("DNI", test.get(0).getTypeDocument());
        assertEquals("12345678", test.get(0).getDocument());
        assertEquals("PERSONAL", test.get(0).getTypeClient());

    }

    @Test
    void updateClientTest() {
        when(clientRepositoryJPA.findById(any())).thenReturn(Optional.of(createClientEntity()));
        when(clientRepositoryJPA.save(any())).thenReturn(createClientEntity());
        Client test = clientRepository.updateClient(createClient());
        assertNotNull(test);
        assertEquals("Cesar", test.getName());
        assertEquals("Ancco", test.getLastName());
        assertEquals("DNI", test.getTypeDocument());
        assertEquals("12345678", test.getDocument());
        assertEquals("PERSONAL", test.getTypeClient());
    }
}
