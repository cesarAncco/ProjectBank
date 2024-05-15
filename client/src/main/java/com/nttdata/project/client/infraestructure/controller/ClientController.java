package com.nttdata.project.client.infraestructure.controller;

import com.nttdata.project.client.application.dto.request.ClientRequest;
import com.nttdata.project.client.application.dto.response.ClientResponse;
import com.nttdata.project.client.domain.dto.entity.ClientEntity;
import com.nttdata.project.client.infraestructure.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/client")
public class ClientController {

    @Autowired
    private IClientService clientService;

    @GetMapping(value = "/clients")
    public ResponseEntity<List<ClientEntity>> findClients() {
        return ResponseEntity.ok(clientService.findAll());
    }

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

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable("id") Long id, @Valid @RequestBody ClientRequest clientRequest) {

        ClientEntity clientEntity = ClientEntity.builder()
                .id(id)
                .name(clientRequest.getName())
                .lastname(clientRequest.getLastname())
                .typeDocument(clientRequest.getTypeDocument())
                .document(clientRequest.getDocument())
                .typeClient(clientRequest.getTypeClient())
                .build();

        clientService.updateClient(clientEntity);

        return ResponseEntity.status(HttpStatus.OK).body(
                ClientResponse.builder()
                        .code("200")
                        .message("Updated Client")
                        .build()

        );
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ClientResponse> deleteClient(@PathVariable("id") Long id) {

        clientService.deleteClient(id);

        return ResponseEntity.status(HttpStatus.OK).body(
                ClientResponse.builder()
                        .code("200")
                        .message("Deleted Client")
                        .build()

        );
    }
}
