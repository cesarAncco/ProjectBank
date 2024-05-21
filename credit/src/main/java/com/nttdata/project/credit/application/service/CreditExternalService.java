package com.nttdata.project.credit.application.service;

import com.nttdata.project.credit.domain.dto.model.Credit;

import java.util.List;

public interface CreditExternalService {
    List<Credit> allCredits();
    Credit saveCredit(Credit credit);
    Credit updateCredit(Credit credit);
    Credit deleteCredit(Long id);
}
