package com.nttdata.project.credit.application.service;

import com.nttdata.project.credit.application.service.impl.CreditExternalServiceCustomImpl;
import com.nttdata.project.credit.application.service.impl.CreditExternalServiceImpl;
import com.nttdata.project.credit.domain.dto.model.Credit;
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
public class CreditExternalServiceCustomImplTest {

    @InjectMocks
    private CreditExternalServiceCustomImpl creditExternalServiceCustom;

    @Mock
    private CreditExternalService creditExternalService;

    @BeforeEach
    void setUp() {
        creditExternalServiceCustom = new CreditExternalServiceCustomImpl(creditExternalService);
    }

    @Test
    void saveCreditTest() {
        when(creditExternalService.saveCredit(any())).thenReturn(util.createCredit());
        Credit test = creditExternalServiceCustom.saveCredit(util.createCredit());
        assertEquals("1", test.getTypeCredit());
        assertEquals(100L, test.getCredits());
    }

    @Test
    void allCreditsTest() {
        when(creditExternalService.allCredits()).thenReturn(util.createCreditList());
        List<Credit> test = creditExternalServiceCustom.allCredits();
        assertEquals("1", test.get(0).getTypeCredit());
        assertEquals(100L, test.get(0).getCredits());

    }

    @Test
    void updateCreditTest() {
        when(creditExternalService.updateCredit(any())).thenReturn(util.createCredit());
        Credit test = creditExternalServiceCustom.updateCredit(util.createCredit());
        assertEquals("1", test.getTypeCredit());
        assertEquals(100L, test.getCredits());
    }

    @Test
    void deleteCreditTest() {
        when(creditExternalService.deleteCredit(any())).thenReturn(util.createCredit());
        Credit test = creditExternalServiceCustom.deleteCredit(util.createCredit().getId());
        assertEquals(1L, test.getId());
    }

}
