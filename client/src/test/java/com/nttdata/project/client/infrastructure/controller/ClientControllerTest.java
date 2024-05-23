package com.nttdata.project.client.infrastructure.controller;

import static com.nttdata.project.client.util.util.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import com.nttdata.project.client.application.dto.request.ClientRequest;
import com.nttdata.project.client.application.dto.request.ClientRequestUpdate;
import com.nttdata.project.client.application.service.ClientExternalServiceCustom;
import com.nttdata.project.client.domain.dto.model.Client;
import com.nttdata.project.client.infraestructure.controller.ClientController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {
    @Mock
    private ClientExternalServiceCustom clientExternalServiceCustom;

    @InjectMocks
    private ClientController clientController;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void findClientsTest() throws Exception {
        List<Client> clients = createClientList();
        when(clientExternalServiceCustom.allClients()).thenReturn(clients);

        mockMvc.perform(get("/api/client/clients"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(clients.size()));
    }

    @Test
    public void saveClientTest() throws Exception {
        ClientRequest clientRequest = createClientRequest();
        when(clientExternalServiceCustom.saveClient(any())).thenReturn(new Client());

        mockMvc.perform(post("/api/client/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.code").value("201"))
                .andExpect(jsonPath("$.message").value("Registered Client"));
    }

    @Test
    public void updateClientTest() throws Exception {
        ClientRequestUpdate clientRequestUpdate = createClientRequestUpdate();
        Long clientId = 1L;
        when(clientExternalServiceCustom.updateClient(any())).thenReturn(new Client());

        mockMvc.perform(put("/api/client/update/{id}", clientId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientRequestUpdate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.message").value("Updated Client"));
    }

    @Test
    public void deleteClientTest() throws Exception {
        Long clientId = 1L;
        when(clientExternalServiceCustom.deleteClient(any())).thenReturn(new Client());

        mockMvc.perform(delete("/api/client/delete/{id}", clientId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.message").value("Deleted Client"));
    }
}
