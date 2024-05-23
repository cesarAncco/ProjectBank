package com.nttdata.project.product.application.service;

import com.nttdata.project.product.application.service.impl.AccountExternalServiceImpl;
import com.nttdata.project.product.domain.dto.model.Account;
import com.nttdata.project.product.domain.service.AccountService;
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
public class AccountExternalServiceImplTest {

    @InjectMocks
    private AccountExternalServiceImpl accountExternalService;

    @Mock
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountExternalService = new AccountExternalServiceImpl(accountService);
    }

    @Test
    void saveClientTest() {
        when(accountService.saveAccount(any())).thenReturn(createAccount());
        Account test = accountExternalService.saveAccount(createAccount());
        assertEquals("1", test.getTypeAccount());
        assertEquals(1000L, test.getBalance());
        assertEquals(100L, test.getCommission());
        assertEquals(10L, test.getMovements());
        assertEquals("Cesar", test.getHeadlines());
        assertEquals("Cesar", test.getSignatories());
    }

    @Test
    void allClientsTest() {
        when(accountService.allCAccounts()).thenReturn(createAccountList());
        List<Account> test = accountExternalService.allAccounts();
        assertEquals("1", test.get(0).getTypeAccount());
        assertEquals(1000L, test.get(0).getBalance());
        assertEquals(100L, test.get(0).getCommission());
        assertEquals(10L, test.get(0).getMovements());
        assertEquals("Cesar", test.get(0).getHeadlines());
        assertEquals("Cesar", test.get(0).getSignatories());

    }

    @Test
    void updateClientTest() {
        when(accountService.updateAccount(any())).thenReturn(createAccount());
        Account test = accountExternalService.updateAccount(createAccount());
        assertEquals("1", test.getTypeAccount());
        assertEquals(1000L, test.getBalance());
        assertEquals(100L, test.getCommission());
        assertEquals(10L, test.getMovements());
        assertEquals("Cesar", test.getHeadlines());
        assertEquals("Cesar", test.getSignatories());
    }

    @Test
    void deleteClientTest() {
        when(accountService.deleteAccount(any())).thenReturn(createAccount());
        Account test = accountExternalService.deleteAccount(createAccount().getId());
        assertEquals(1L, test.getId());
    }

}
