package com.nttdata.project.client.infraestructure.repository.dto;

import com.nttdata.project.client.domain.dto.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    public ClientEntity findByDocument(String document);
}
