package com.nttdata.project.credit.domain.service;

import com.nttdata.project.credit.application.service.impl.CreditExternalServiceImpl;
import com.nttdata.project.credit.domain.dto.model.Credit;
import com.nttdata.project.credit.domain.repository.CreditRepository;
import com.nttdata.project.credit.domain.service.impl.CreditServiceImpl;
import com.nttdata.project.credit.util.util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreditServiceTest {

    @InjectMocks
    private CreditServiceImpl creditService;

    @Mock
    private CreditRepository creditRepository;

    @BeforeEach
    void setUp() {
        creditService = new CreditServiceImpl(creditRepository);
    }

    @Test
    void saveCreditTest() {
        when(creditRepository.saveCredit(any())).thenReturn(util.createCredit());
        Credit test = creditService.saveCredit(util.createCredit());
        assertEquals("1", test.getTypeCredit());
        assertEquals(100L, test.getCredits());
    }

    @Test
    void allCreditsTest() {
        when(creditRepository.allCredits()).thenReturn(util.createCreditList());
        List<Credit> test = creditService.allCredits();
        assertEquals("1", test.get(0).getTypeCredit());
        assertEquals(100L, test.get(0).getCredits());

    }

    @Test
    void updateCreditTest() {
        when(creditRepository.updateCredit(any())).thenReturn(util.createCredit());
        Credit test = creditService.updateCredit(util.createCredit());
        assertEquals("1", test.getTypeCredit());
        assertEquals(100L, test.getCredits());
    }

    @Test
    void deleteCreditTest() {
        when(creditRepository.deleteCredit(any())).thenReturn(util.createCredit());
        Credit test = creditService.deleteCredit(util.createCredit().getId());
        assertEquals(1L, test.getId());
    }

}
