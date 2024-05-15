package com.nttdata.project.client.infraestructure.controller;

import com.nttdata.project.client.application.dto.request.ClientRequest;
import com.nttdata.project.client.application.dto.response.ClientResponse;
import com.nttdata.project.client.domain.dto.entity.ClientEntity;
import com.nttdata.project.client.infraestructure.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping(value = "/create")
    public ResponseEntity<ClientResponse> saveClient(@Valid @RequestBody ClientRequest clientRequest) {
        // guardando el cliente
        ClientEntity clientEntity = ClientEntity.builder()
                .name(clientRequest.getName())
                .lastname(clientRequest.getLastname())
                .typeDocument(clientRequest.getTypeDocument())
                .document(clientRequest.getDocument())
                .typeClient(clientRequest.getTypeClient())
                .build();

        clientService.createClient(clientEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                ClientResponse.builder()
                        .code("201")
                        .message("Registered Client")
                        .build()

        );
    }
}
