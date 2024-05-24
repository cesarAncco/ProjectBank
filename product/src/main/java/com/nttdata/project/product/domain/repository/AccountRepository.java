package com.nttdata.project.product.domain.repository;

import com.nttdata.project.product.domain.dto.model.Account;

import java.util.List;

/**
 * AccountRepository: the interface will refer to all the methods that will be implemented
 */

public interface AccountRepository {
    List<Account> allAccounts();
    Account saveAccount(Account account);
    Account updateAccount(Account account);
    Account deleteAccount(Long id);
}
