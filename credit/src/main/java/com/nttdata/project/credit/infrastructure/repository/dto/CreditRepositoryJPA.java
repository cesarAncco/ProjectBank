package com.nttdata.project.credit.infrastructure.repository.dto;

import com.nttdata.project.credit.domain.dto.entity.CreditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepositoryJPA extends JpaRepository<CreditEntity, Long> {
}
