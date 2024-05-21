package com.nttdata.project.product.application.service;

import com.nttdata.project.product.domain.dto.model.Account;

import java.util.List;

public interface AccountExternalServiceCustom {
    List<Account> allAccounts();
    Account saveAccount(Account account);
    Account updateAccount(Account account);
    Account deleteAccount(Long id);
}
