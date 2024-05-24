package com.nttdata.project.client.infraestructure.controller;

import com.nttdata.project.client.application.dto.request.ClientRequest;
import com.nttdata.project.client.application.dto.request.ClientRequestUpdate;
import com.nttdata.project.client.application.dto.response.ClientResponse;
import com.nttdata.project.client.application.mapper.ClientMapper;
import com.nttdata.project.client.application.service.ClientExternalServiceCustom;
import com.nttdata.project.client.domain.dto.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @RestController: Indicates that the class is a Spring MVC controller
 * @RequestMapping: This annotation is used to map web requests.
 * @GetMapping: GET method to contain a list of clients
 * @PostMapping: POST method for creating clients
 * @PutMapping: PUT method for updating clients
 * @DeleteMapping: DELTE method to delete a client
 */

@RestController
@RequestMapping(value = "api/client")
@AllArgsConstructor
public class ClientController {

    private final ClientExternalServiceCustom clientExternalServiceCustom;


    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> findClients() {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                clientExternalServiceCustom.allClients()
        );
    }

    @PostMapping(value = "/create")
    public ResponseEntity<ClientResponse> saveClient(@Valid @RequestBody ClientRequest clientRequest) {
        clientExternalServiceCustom.saveClient(ClientMapper.INSTANCE.mapToClient(clientRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ClientResponse.builder()
                        .code("201")
                        .message("Registered Client")
                        .build()

        );
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ClientResponse> updateClient(@PathVariable("id") Long id, @Valid @RequestBody ClientRequestUpdate clientRequestUpdate) {

        clientExternalServiceCustom.updateClient(ClientMapper.INSTANCE.mapToClientUpdate(id, clientRequestUpdate));

        return ResponseEntity.status(HttpStatus.OK).body(
                ClientResponse.builder()
                        .code("200")
                        .message("Updated Client")
                        .build()

        );
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ClientResponse> deleteClient(@PathVariable("id") Long id) {
        clientExternalServiceCustom.deleteClient(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                ClientResponse.builder()
                        .code("200")
                        .message("Deleted Client")
                        .build()

        );
    }
}
