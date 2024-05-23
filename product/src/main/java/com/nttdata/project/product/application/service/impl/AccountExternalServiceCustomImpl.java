package com.nttdata.project.product.application.service.impl;

import com.nttdata.project.product.application.service.AccountExternalService;
import com.nttdata.project.product.domain.dto.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountExternalServiceCustomImpl implements com.nttdata.project.product.application.service.AccountExternalServiceCustom {

    private final AccountExternalService accountExternalService;

    @Override
    public List<Account> allAccounts() {
        return accountExternalService.allAccounts();
    }

    @Override
    public Account saveAccount(Account account) {
        return accountExternalService.saveAccount(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountExternalService.updateAccount(account);
    }

    @Override
    public Account deleteAccount(Long id) {
        return accountExternalService.deleteAccount(id);
    }
}
