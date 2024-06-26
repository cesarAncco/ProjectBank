package com.nttdata.project.credit.application.service.impl;

import com.nttdata.project.credit.application.service.CreditExternalService;
import com.nttdata.project.credit.application.service.CreditExternalServiceCustom;
import com.nttdata.project.credit.domain.dto.model.Credit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * We implement the methods that we place in the interface
 * @Service: we instantiate that this class is a service
 * We use the CreditExternalService to be able to use its methods
 */

@Service
@AllArgsConstructor
public class CreditExternalServiceCustomImpl implements CreditExternalServiceCustom {

    private final CreditExternalService creditExternalService;

    @Override
    public List<Credit> allCredits() {
        return creditExternalService.allCredits();
    }

    @Override
    public Credit saveCredit(Credit credit) {
        return creditExternalService.saveCredit(credit);
    }

    @Override
    public Credit updateCredit(Credit credit) {
        return creditExternalService.updateCredit(credit);
    }

    @Override
    public Credit deleteCredit(Long id) {
        return creditExternalService.deleteCredit(id);
    }
}
