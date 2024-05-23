package com.nttdata.project.credit.application.service;

import com.nttdata.project.credit.application.service.impl.CreditExternalServiceCustomImpl;
import com.nttdata.project.credit.application.service.impl.CreditExternalServiceImpl;
import com.nttdata.project.credit.domain.dto.model.Credit;
import com.nttdata.project.credit.domain.service.CreditService;
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
public class CreditExternalServiceImplTest {

    @InjectMocks
    private CreditExternalServiceImpl creditExternalService;

    @Mock
    private CreditService creditEService;

    @BeforeEach
    void setUp() {
        creditExternalService = new CreditExternalServiceImpl(creditEService);
    }

    @Test
    void saveCreditTest() {
        when(creditEService.saveCredit(any())).thenReturn(util.createCredit());
        Credit test = creditExternalService.saveCredit(util.createCredit());
        assertEquals("1", test.getTypeCredit());
        assertEquals(100L, test.getCredits());
    }

    @Test
    void allCreditsTest() {
        when(creditEService.allCredits()).thenReturn(util.createCreditList());
        List<Credit> test = creditExternalService.allCredits();
        assertEquals("1", test.get(0).getTypeCredit());
        assertEquals(100L, test.get(0).getCredits());

    }

    @Test
    void updateCreditTest() {
        when(creditEService.updateCredit(any())).thenReturn(util.createCredit());
        Credit test = creditExternalService.updateCredit(util.createCredit());
        assertEquals("1", test.getTypeCredit());
        assertEquals(100L, test.getCredits());
    }

    @Test
    void deleteCreditTest() {
        when(creditEService.deleteCredit(any())).thenReturn(util.createCredit());
        Credit test = creditExternalService.deleteCredit(util.createCredit().getId());
        assertEquals(1L, test.getId());
    }
}
