package com.nttdata.project.client.infraestructure.controller;

import com.nttdata.project.client.application.dto.request.ClientRequest;
import com.nttdata.project.client.application.dto.response.ClientResponse;
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
    @PostMapping(value = "/register")
    public ResponseEntity<ClientResponse> saveClient(@Valid @RequestBody ClientRequest clientRequest) {
        // guardando el cliente
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ClientResponse.builder()
                        .code("201")
                        .message("Client created")
                        .build()

        );
    }
}
