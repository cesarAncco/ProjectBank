package com.nttdata.project.client.infraestructure.repository.dto;

import com.nttdata.project.client.domain.dto.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    public ClientEntity findByDocument(String document);
}
