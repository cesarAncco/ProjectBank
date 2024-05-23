package com.nttdata.project.credit.application.service.impl;

import com.nttdata.project.credit.application.service.CreditExternalService;
import com.nttdata.project.credit.domain.dto.model.Credit;
import com.nttdata.project.credit.domain.service.CreditService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CreditExternalServiceImpl implements CreditExternalService {

    private final CreditService creditService;

    @Override
    public List<Credit> allCredits() {
        return creditService.allCredits();
    }

    @Override
    public Credit saveCredit(Credit credit) {
        return creditService.saveCredit(credit);
    }

    @Override
    public Credit updateCredit(Credit credit) {
        return creditService.updateCredit(credit);
    }

    @Override
    public Credit deleteCredit(Long id) {
        return creditService.deleteCredit(id);
    }
}
