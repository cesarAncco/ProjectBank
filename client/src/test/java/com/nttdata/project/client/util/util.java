package com.nttdata.project.client.util;

import com.nttdata.project.client.application.dto.request.ClientRequest;
import com.nttdata.project.client.application.dto.request.ClientRequestUpdate;
import com.nttdata.project.client.domain.dto.entity.ClientEntity;
import com.nttdata.project.client.domain.dto.entity.ClientTypeEntity;
import com.nttdata.project.client.domain.dto.entity.DocumentTypeEntity;
import com.nttdata.project.client.domain.dto.model.Client;

import java.util.List;

public class util {

    public static Client createClient() {
        return Client.builder()
                .id(1L)
                .name("Cesar")
                .lastName("Ancco")
                .typeDocument("1")
                .document("12345678")
                .typeClient("1")
                .build();
    }

    public static List<Client> createClientList() {
        return List.of(Client.builder()
                .id(1L)
                .name("Cesar")
                .lastName("Ancco")
                .typeDocument("1")
                .document("12345678")
                .typeClient("1")
                .build());
    }


    public static ClientEntity createClientEntity() {
        return ClientEntity.builder()
                .id(1L)
                .name("Cesar")
                .lastName("Ancco")
                .typeDocument(DocumentTypeEntity.builder().id(1L).documentName("DNI").build())
                .document("12345678")
                .typeClient(ClientTypeEntity.builder().id(1L).clientTypeName("PERSONAL").build())
                .build();
    }

    public static List<ClientEntity> createClientEntityList() {
        return List.of(ClientEntity.builder()
                .id(1L)
                .name("Cesar")
                .lastName("Ancco")
                .typeDocument(DocumentTypeEntity.builder().id(1L).documentName("DNI").build())
                .document("12345678")
                .typeClient(ClientTypeEntity.builder().id(1L).clientTypeName("PERSONAL").build())
                .build());
    }

    public static ClientRequest createClientRequest() {
        return ClientRequest.builder()
                .name("Cesar")
                .lastName("Ancco")
                .typeDocument("1")
                .document("12345678")
                .typeClient("1")
                .build();
    }

    public static ClientRequestUpdate createClientRequestUpdate() {
        return ClientRequestUpdate.builder()
                .name("Cesar")
                .lastName("Ancco")
                .typeDocument("1")
                .document("12345678")
                .typeClient("1")
                .build();
    }
}
