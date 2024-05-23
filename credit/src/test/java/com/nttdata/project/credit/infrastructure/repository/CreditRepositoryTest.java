package com.nttdata.project.credit.infrastructure.repository;

import com.nttdata.project.credit.domain.dto.model.Credit;
import com.nttdata.project.credit.infrastructure.repository.dto.CreditRepositoryJPA;
import com.nttdata.project.credit.infrastructure.repository.impl.CreditRepositoryImpl;
import com.nttdata.project.credit.util.util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreditRepositoryTest {
    @InjectMocks
    private CreditRepositoryImpl creditRepository;

    @Mock
    private CreditRepositoryJPA creditRepositoryJPA;

    @BeforeEach
    void setUp() {
        creditRepository = new CreditRepositoryImpl(creditRepositoryJPA);
    }

    @Test
    void saveCreditTest() {
        when(creditRepositoryJPA.save(any())).thenReturn(util.createCreditEntity());
        Credit test = creditRepository.saveCredit(util.createCredit());
        assertEquals("PERSONAL", test.getTypeCredit());
        assertEquals(100L, test.getCredits());
    }

    @Test
    void allCreditsTest() {
        when(creditRepositoryJPA.findAll()).thenReturn(util.createCreditEntityList());
        List<Credit> test = creditRepository.allCredits();
        assertEquals("PERSONAL", test.get(0).getTypeCredit());
        assertEquals(100L, test.get(0).getCredits());

    }

    @Test
    void updateCreditTest() {
        when(creditRepositoryJPA.findById(any())).thenReturn(Optional.of(util.createCreditEntity()));
        when(creditRepositoryJPA.save(any())).thenReturn(util.createCreditEntity());
        Credit test = creditRepository.updateCredit(util.createCredit());
        assertEquals("PERSONAL", test.getTypeCredit());
        assertEquals(100L, test.getCredits());
    }
}
