package com.nttdata.project.client.infraestructure.mapper;

import com.nttdata.project.client.domain.dto.entity.ClientEntity;
import com.nttdata.project.client.domain.dto.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ClientEntityMapper interface to be able to map Entities
 * mapToClient: to map from ClientEntity to Client
 * mapToClientEntity: to map from Client to ClientEntity
 */

@Mapper
public interface ClientEntityMapper {

    ClientEntityMapper INSTANCE = Mappers.getMapper(ClientEntityMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "typeDocument", source = "typeDocument.documentName")
    @Mapping(target = "document", source = "document")
    @Mapping(target = "typeClient", source = "typeClient.clientTypeName")
    Client mapToClient(ClientEntity clientEntity);

    List<Client> mapToClient(List<ClientEntity> clientEntities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "typeDocument.id", source = "typeDocument")
    @Mapping(target = "document", source = "document")
    @Mapping(target = "typeClient.id", source = "typeClient")
    ClientEntity mapToClientEntity(Client client);
}
