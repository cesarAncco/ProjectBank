package com.nttdata.project.product.infrastructure.respository;

import com.nttdata.project.product.domain.dto.model.Account;
import com.nttdata.project.product.domain.repository.AccountRepository;
import com.nttdata.project.product.domain.service.impl.AccountServiceImpl;
import com.nttdata.project.product.infrastructure.reposity.dto.AccountRepositoryJPA;
import com.nttdata.project.product.infrastructure.reposity.impl.AccountRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.nttdata.project.product.util.util.createAccount;
import static com.nttdata.project.product.util.util.createAccountEntity;
import static com.nttdata.project.product.util.util.createAccountList;
import static com.nttdata.project.product.util.util.createAccountEntityList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountRepositoryTest {

    @InjectMocks
    private AccountRepositoryImpl accountRepository;

    @Mock
    private AccountRepositoryJPA accountRepositoryJPA;

    @BeforeEach
    void setUp() {
        accountRepository = new AccountRepositoryImpl(accountRepositoryJPA);
    }

    @Test
    void saveClientTest() {
        when(accountRepositoryJPA.save(any())).thenReturn(createAccountEntity());
        Account test = accountRepository.saveAccount(createAccount());
        assertEquals("AHORRO", test.getTypeAccount());
        assertEquals(1000L, test.getBalance());
        assertEquals(100L, test.getCommission());
        assertEquals(10L, test.getMovements());
        assertEquals("Cesar", test.getHeadlines());
        assertEquals("Cesar", test.getSignatories());
    }

    @Test
    void allClientsTest() {
        when(accountRepositoryJPA.findAll()).thenReturn(createAccountEntityList());
        List<Account> test = accountRepository.allAccounts();
        assertEquals("AHORRO", test.get(0).getTypeAccount());
        assertEquals(1000L, test.get(0).getBalance());
        assertEquals(100L, test.get(0).getCommission());
        assertEquals(10L, test.get(0).getMovements());
        assertEquals("Cesar", test.get(0).getHeadlines());
        assertEquals("Cesar", test.get(0).getSignatories());

    }

    @Test
    void updateClientTest() {
        when(accountRepositoryJPA.findById(any())).thenReturn(Optional.of(createAccountEntity()));
        when(accountRepositoryJPA.save(any())).thenReturn(createAccountEntity());
        Account test = accountRepository.updateAccount(createAccount());
        assertEquals("AHORRO", test.getTypeAccount());
        assertEquals(1000L, test.getBalance());
        assertEquals(100L, test.getCommission());
        assertEquals(10L, test.getMovements());
        assertEquals("Cesar", test.getHeadlines());
        assertEquals("Cesar", test.getSignatories());
    }
}
