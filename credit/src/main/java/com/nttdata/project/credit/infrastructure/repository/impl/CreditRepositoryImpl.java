package com.nttdata.project.credit.infrastructure.repository.impl;

import com.nttdata.project.credit.domain.dto.entity.CreditEntity;
import com.nttdata.project.credit.domain.dto.model.Credit;
import com.nttdata.project.credit.domain.repository.CreditRepository;
import com.nttdata.project.credit.infrastructure.mapper.CreditEntityMapper;
import com.nttdata.project.credit.infrastructure.repository.dto.CreditRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class CreditRepositoryImpl implements CreditRepository {

    private final CreditRepositoryJPA creditRepositoryJPA;

    @Override
    public List<Credit> allCredits() {
        return CreditEntityMapper.INSTANCE.mapToCredit(creditRepositoryJPA.findAll());
    }

    @Override
    public Credit saveCredit(Credit credit) {
        return CreditEntityMapper.INSTANCE.mapToCredit(
                creditRepositoryJPA.save(CreditEntityMapper.INSTANCE.mapToCreditEntity(credit))
        );
    }

    @Override
    public Credit updateCredit(Credit credit) {
        creditRepositoryJPA.findById(credit.getId())
                .orElseThrow(() -> new NoSuchElementException("Credit not found"));
        return CreditEntityMapper.INSTANCE.mapToCredit(
                creditRepositoryJPA.save(CreditEntityMapper.INSTANCE.mapToCreditEntity(credit))
        );
    }

    @Override
    public Credit deleteCredit(Long id) {
        CreditEntity creditEntity = creditRepositoryJPA.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Credit with id" + id + "not found"));
        creditRepositoryJPA.delete(creditEntity);
        return CreditEntityMapper.INSTANCE.mapToCredit(creditEntity);
    }
}
