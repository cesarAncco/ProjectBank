package com.nttdata.project.product.domain.service;

import com.nttdata.project.product.domain.dto.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> allCAccounts();
    Account saveAccount(Account account);
    Account updateAccount(Account account);
    Account deleteAccount(Long id);
}
