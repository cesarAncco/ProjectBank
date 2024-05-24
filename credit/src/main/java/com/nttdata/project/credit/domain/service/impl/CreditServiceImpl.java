package com.nttdata.project.credit.domain.service.impl;

import com.nttdata.project.credit.domain.dto.model.Credit;
import com.nttdata.project.credit.domain.repository.CreditRepository;
import com.nttdata.project.credit.domain.service.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CreditServiceImpl.class in this class we are going to implement all the methods of the interface.
 * @Service: we indicate that this class will be a service
 * We use the CreditRepository interface to use its methods in the service
 */

@Service
@AllArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;

    @Override
    public List<Credit> allCredits() {
        return creditRepository.allCredits();
    }

    @Override
    public Credit saveCredit(Credit credit) {
        return creditRepository.saveCredit(credit);
    }

    @Override
    public Credit updateCredit(Credit credit) {
        return creditRepository.updateCredit(credit);
    }

    @Override
    public Credit deleteCredit(Long id) {
        return creditRepository.deleteCredit(id);
    }
}
