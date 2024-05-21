package com.nttdata.project.product.domain.service.impl;

import com.nttdata.project.product.domain.dto.model.Account;
import com.nttdata.project.product.domain.repository.AccountRepository;
import com.nttdata.project.product.domain.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> allCAccounts() {
        return accountRepository.allAccounts();
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.saveAccount(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.updateAccount(account);
    }

    @Override
    public Account deleteAccount(Long id) {
        return accountRepository.deleteAccount(id);
    }
}
