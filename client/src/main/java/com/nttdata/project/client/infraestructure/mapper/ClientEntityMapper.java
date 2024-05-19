package com.nttdata.project.client.infraestructure.mapper;

import com.nttdata.project.client.domain.dto.entity.ClientEntity;
import com.nttdata.project.client.domain.dto.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientEntityMapper {

    ClientEntityMapper INSTANCE = Mappers.getMapper(ClientEntityMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "typeDocument", source = "typeDocument")
    @Mapping(target = "document", source = "document")
    @Mapping(target = "typeClient", source = "typeClient")
    Client mapToClient(ClientEntity clientEntity);

    List<Client> mapToClient(List<ClientEntity> clientEntities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "typeDocument", source = "typeDocument")
    @Mapping(target = "document", source = "document")
    @Mapping(target = "typeClient", source = "typeClient")
    ClientEntity mapToClientEntity(Client client);
}
