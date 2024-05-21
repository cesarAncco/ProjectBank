package com.nttdata.project.product.infrastructure.reposity.impl;

import com.nttdata.project.product.domain.dto.entity.AccountEntity;
import com.nttdata.project.product.domain.dto.model.Account;
import com.nttdata.project.product.domain.repository.AccountRepository;
import com.nttdata.project.product.infrastructure.mapper.AccountEntityMapper;
import com.nttdata.project.product.infrastructure.reposity.dto.AccountRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountRepositoryJPA accountRepositoryJPA;


    @Override
    public List<Account> allAccounts() {
        return AccountEntityMapper.INSTANCE.mapToAccount(accountRepositoryJPA.findAll());
    }

    @Override
    public Account saveAccount(Account account) {
        return AccountEntityMapper.INSTANCE.mapToAccount(
                accountRepositoryJPA.save(AccountEntityMapper.INSTANCE.mapToAccountEntity(account))
        );
    }

    @Override
    public Account updateAccount(Account account) {
        accountRepositoryJPA.findById(account.getId())
                .orElseThrow(() -> new NoSuchElementException("Account not found."));

        return AccountEntityMapper.INSTANCE.mapToAccount(
                accountRepositoryJPA.save(AccountEntityMapper.INSTANCE.mapToAccountEntity(account))
        );
    }

    @Override
    public Account deleteAccount(Long id) {
        AccountEntity accountEntity = accountRepositoryJPA.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Account with id " + id + " not found."));
        accountRepositoryJPA.delete(accountEntity);
        return AccountEntityMapper.INSTANCE.mapToAccount(accountEntity);
    }
}
