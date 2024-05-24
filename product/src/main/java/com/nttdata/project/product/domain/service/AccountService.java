package com.nttdata.project.product.domain.service;

import com.nttdata.project.product.domain.dto.model.Account;

import java.util.List;

/**
 * AccountService: interface to reference all the methods to be implemented
 */

public interface AccountService {
    List<Account> allCAccounts();
    Account saveAccount(Account account);
    Account updateAccount(Account account);
    Account deleteAccount(Long id);
}
