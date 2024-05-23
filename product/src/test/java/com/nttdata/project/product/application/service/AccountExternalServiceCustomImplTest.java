package com.nttdata.project.product.application.service;

import com.nttdata.project.product.application.service.impl.AccountExternalServiceCustomImpl;
import com.nttdata.project.product.domain.dto.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.nttdata.project.product.util.util.createAccountList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static com.nttdata.project.product.util.util.createAccount;

@ExtendWith(MockitoExtension.class)
public class AccountExternalServiceCustomImplTest {

    @InjectMocks
    private AccountExternalServiceCustomImpl accountExternalServiceCustom;

    @Mock
    private AccountExternalService accountExternalService;

    @BeforeEach
    void setUp() {
        accountExternalServiceCustom = new AccountExternalServiceCustomImpl(accountExternalService);
    }

    @Test
    void saveClientTest() {
        when(accountExternalService.saveAccount(any())).thenReturn(createAccount());
        Account test = accountExternalServiceCustom.saveAccount(createAccount());
        assertEquals("1", test.getTypeAccount());
        assertEquals(1000L, test.getBalance());
        assertEquals(100L, test.getCommission());
        assertEquals(10L, test.getMovements());
        assertEquals("Cesar", test.getHeadlines());
        assertEquals("Cesar", test.getSignatories());
    }

    @Test
    void allClientsTest() {
        when(accountExternalService.allAccounts()).thenReturn(createAccountList());
        List<Account> test = accountExternalServiceCustom.allAccounts();
        assertEquals("1", test.get(0).getTypeAccount());
        assertEquals(1000L, test.get(0).getBalance());
        assertEquals(100L, test.get(0).getCommission());
        assertEquals(10L, test.get(0).getMovements());
        assertEquals("Cesar", test.get(0).getHeadlines());
        assertEquals("Cesar", test.get(0).getSignatories());

    }

    @Test
    void updateClientTest() {
        when(accountExternalService.updateAccount(any())).thenReturn(createAccount());
        Account test = accountExternalServiceCustom.updateAccount(createAccount());
        assertEquals("1", test.getTypeAccount());
        assertEquals(1000L, test.getBalance());
        assertEquals(100L, test.getCommission());
        assertEquals(10L, test.getMovements());
        assertEquals("Cesar", test.getHeadlines());
        assertEquals("Cesar", test.getSignatories());
    }

    @Test
    void deleteClientTest() {
        when(accountExternalService.deleteAccount(any())).thenReturn(createAccount());
        Account test = accountExternalServiceCustom.deleteAccount(createAccount().getId());
        assertEquals(1L, test.getId());
    }

}
