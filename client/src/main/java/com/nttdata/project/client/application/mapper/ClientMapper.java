package com.nttdata.project.client.application.mapper;

import com.nttdata.project.client.application.dto.request.ClientRequest;
import com.nttdata.project.client.application.dto.request.ClientRequestUpdate;
import com.nttdata.project.client.domain.dto.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    default Client mapToClient(ClientRequest clientRequest) {
        return Client.builder()
                .name(clientRequest.getName())
                .lastName(clientRequest.getLastName())
                .typeDocument(clientRequest.getTypeDocument())
                .document(clientRequest.getDocument())
                .typeClient(clientRequest.getTypeClient())
                .build();
    }

    default Client mapToClientUpdate(Long id, ClientRequestUpdate clientRequestUpdate) {
        return Client.builder()
                .id(id)
                .name(clientRequestUpdate.getName())
                .lastName(clientRequestUpdate.getLastName())
                .typeDocument(clientRequestUpdate.getTypeDocument())
                .document(clientRequestUpdate.getDocument())
                .typeClient(clientRequestUpdate.getTypeClient())
                .build();
    }
}
