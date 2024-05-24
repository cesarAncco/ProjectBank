package com.nttdata.project.product.infrastructure.reposity.dto;

import com.nttdata.project.product.domain.dto.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AccountRepositoryJPA that extends JpaRepository to have basic JPA functionalities
 */

public interface AccountRepositoryJPA extends JpaRepository<AccountEntity, Long> {
}
