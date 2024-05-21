package com.nttdata.project.product.domain.repository;

import com.nttdata.project.product.domain.dto.model.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> allAccounts();
    Account saveAccount(Account account);
    Account updateAccount(Account account);
    Account deleteAccount(Long id);
}
