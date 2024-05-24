package com.nttdata.project.product.application.service.impl;

import com.nttdata.project.product.application.service.AccountExternalService;
import com.nttdata.project.product.domain.dto.model.Account;
import com.nttdata.project.product.domain.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * We implement the methods that were placed in the AccountExternalService interface
 * @Service: we instantiate that this class is a service
 * The AccountService is used to be able to use its functions
 */

@Service
@AllArgsConstructor
public class AccountExternalServiceImpl implements AccountExternalService {

    private final AccountService accountService;

    @Override
    public List<Account> allAccounts() {
        return accountService.allCAccounts();
    }

    @Override
    public Account saveAccount(Account account) {
        return accountService.saveAccount(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountService.updateAccount(account);
    }

    @Override
    public Account deleteAccount(Long id) {
        return accountService.deleteAccount(id);
    }
}
