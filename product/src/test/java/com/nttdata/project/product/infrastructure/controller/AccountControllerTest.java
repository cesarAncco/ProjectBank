package com.nttdata.project.product.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.project.product.application.dto.request.AccountRequest;
import com.nttdata.project.product.application.dto.request.AccountRequestUpdate;
import com.nttdata.project.product.application.service.AccountExternalServiceCustom;
import com.nttdata.project.product.domain.dto.model.Account;
import com.nttdata.project.product.util.util;
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

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
    @Mock
    private AccountExternalServiceCustom accountExternalServiceCustom;

    @InjectMocks
    private AccountController accountController;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void findClientsTest() throws Exception {
        List<Account> accounts = util.createAccountList();
        when(accountExternalServiceCustom.allAccounts()).thenReturn(accounts);

        mockMvc.perform(get("/api/account/accounts"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(accounts.size()));
    }

    @Test
    public void saveClientTest() throws Exception {
        AccountRequest clientRequest = util.createAccountRequest();
        when(accountExternalServiceCustom.saveAccount(any())).thenReturn(new Account());

        mockMvc.perform(post("/api/account/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.code").value("201"))
                .andExpect(jsonPath("$.message").value("Registered Account"));
    }

    @Test
    public void updateClientTest() throws Exception {
        AccountRequestUpdate clientRequestUpdate = util.createAccountRequestUpdate();
        Long clientId = 1L;
        when(accountExternalServiceCustom.updateAccount(any())).thenReturn(new Account());

        mockMvc.perform(put("/api/account/update/{id}", clientId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(clientRequestUpdate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.message").value("Updated Account"));
    }

    @Test
    public void deleteClientTest() throws Exception {
        Long clientId = 1L;
        when(accountExternalServiceCustom.deleteAccount(any())).thenReturn(new Account());

        mockMvc.perform(delete("/api/account/delete/{id}", clientId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.message").value("Deleted Account"));
    }
}
