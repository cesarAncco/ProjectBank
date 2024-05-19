package com.nttdata.project.client.infraestructure.controller;

import com.nttdata.project.client.application.dto.request.ClientRequest;
import com.nttdata.project.client.application.dto.request.ClientRequestUpdate;
import com.nttdata.project.client.application.dto.response.ClientResponse;
import com.nttdata.project.client.application.mapper.ClientMapper;
import com.nttdata.project.client.application.service.ClientExternalService;
import com.nttdata.project.client.application.service.ClientExternalServiceCustom;
import com.nttdata.project.client.domain.dto.entity.ClientEntity;
import com.nttdata.project.client.domain.dto.model.Client;
import com.nttdata.project.client.infraestructure.service.IClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    /**
    @GetMapping(value = "/client/{id}")
    public ResponseEntity<ClientEntity> findClientById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @GetMapping(value = "/client/{document}")
    public ResponseEntity<ClientEntity> findClientByDocument(@PathVariable("document") String document) {
        return ResponseEntity.ok(clientService.findByDocument(document));
    }**/

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
