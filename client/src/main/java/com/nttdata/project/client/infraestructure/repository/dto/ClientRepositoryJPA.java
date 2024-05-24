package com.nttdata.project.client.infraestructure.repository.dto;

import com.nttdata.project.client.domain.dto.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClientRepositoryJPA that extends JpaRepository to have basic JPA functionalities
 */

public interface ClientRepositoryJPA extends JpaRepository<ClientEntity, Long> {

}
