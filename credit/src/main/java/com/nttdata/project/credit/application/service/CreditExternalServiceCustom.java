package com.nttdata.project.credit.application.service;

import com.nttdata.project.credit.domain.dto.model.Credit;

import java.util.List;

/**
 * In CreditExternalServiceCustom we place functions so that we can later implement them
 */

public interface CreditExternalServiceCustom {
    List<Credit> allCredits();
    Credit saveCredit(Credit credit);
    Credit updateCredit(Credit credit);
    Credit deleteCredit(Long id);
}
