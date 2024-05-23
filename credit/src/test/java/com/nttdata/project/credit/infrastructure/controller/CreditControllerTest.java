package com.nttdata.project.credit.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.project.credit.application.dto.request.CreditRequest;
import com.nttdata.project.credit.application.dto.request.CreditRequestUpdate;
import com.nttdata.project.credit.application.service.CreditExternalServiceCustom;
import com.nttdata.project.credit.domain.dto.model.Credit;
import com.nttdata.project.credit.util.util;
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
public class CreditControllerTest {
    @Mock
    private CreditExternalServiceCustom creditExternalServiceCustom;

    @InjectMocks
    private CreditController creditController;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(creditController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void findClientsTest() throws Exception {
        List<Credit> credit = util.createCreditList();
        when(creditExternalServiceCustom.allCredits()).thenReturn(credit);

        mockMvc.perform(get("/api/credit/credits"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(credit.size()));
    }

    @Test
    public void saveClientTest() throws Exception {
        CreditRequest creditRequest = util.createCreditRequest();
        when(creditExternalServiceCustom.saveCredit(any())).thenReturn(new Credit());

        mockMvc.perform(post("/api/credit/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(creditRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.code").value("201"))
                .andExpect(jsonPath("$.message").value("Registered Credit"));
    }

    @Test
    public void updateClientTest() throws Exception {
        CreditRequestUpdate creditRequestUpdate = util.createCreditRequestUpdate();
        Long clientId = 1L;
        when(creditExternalServiceCustom.updateCredit(any())).thenReturn(new Credit());

        mockMvc.perform(put("/api/credit/update/{id}", clientId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(creditRequestUpdate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.message").value("Updated Credit"));
    }

    @Test
    public void deleteClientTest() throws Exception {
        Long clientId = 1L;
        when(creditExternalServiceCustom.deleteCredit(any())).thenReturn(new Credit());

        mockMvc.perform(delete("/api/credit/delete/{id}", clientId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("200"))
                .andExpect(jsonPath("$.message").value("Deleted Credit"));
    }
}
