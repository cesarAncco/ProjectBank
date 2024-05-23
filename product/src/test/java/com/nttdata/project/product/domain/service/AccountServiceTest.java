package com.nttdata.project.product.domain.service;

import com.nttdata.project.product.domain.dto.model.Account;
import com.nttdata.project.product.domain.repository.AccountRepository;
import com.nttdata.project.product.domain.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.nttdata.project.product.util.util.createAccount;
import static com.nttdata.project.product.util.util.createAccountList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        accountService = new AccountServiceImpl(accountRepository);
    }

    @Test
    void saveClientTest() {
        when(accountRepository.saveAccount(any())).thenReturn(createAccount());
        Account test = accountService.saveAccount(createAccount());
        assertEquals("1", test.getTypeAccount());
        assertEquals(1000L, test.getBalance());
        assertEquals(100L, test.getCommission());
        assertEquals(10L, test.getMovements());
        assertEquals("Cesar", test.getHeadlines());
        assertEquals("Cesar", test.getSignatories());
    }

    @Test
    void allClientsTest() {
        when(accountRepository.allAccounts()).thenReturn(createAccountList());
        List<Account> test = accountService.allCAccounts();
        assertEquals("1", test.get(0).getTypeAccount());
        assertEquals(1000L, test.get(0).getBalance());
        assertEquals(100L, test.get(0).getCommission());
        assertEquals(10L, test.get(0).getMovements());
        assertEquals("Cesar", test.get(0).getHeadlines());
        assertEquals("Cesar", test.get(0).getSignatories());

    }

    @Test
    void updateClientTest() {
        when(accountRepository.updateAccount(any())).thenReturn(createAccount());
        Account test = accountService.updateAccount(createAccount());
        assertEquals("1", test.getTypeAccount());
        assertEquals(1000L, test.getBalance());
        assertEquals(100L, test.getCommission());
        assertEquals(10L, test.getMovements());
        assertEquals("Cesar", test.getHeadlines());
        assertEquals("Cesar", test.getSignatories());
    }

    @Test
    void deleteClientTest() {
        when(accountRepository.deleteAccount(any())).thenReturn(createAccount());
        Account test = accountService.deleteAccount(createAccount().getId());
        assertEquals(1L, test.getId());
    }

}
