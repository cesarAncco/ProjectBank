package com.nttdata.project.credit.application.service;

import com.nttdata.project.credit.domain.dto.model.Credit;

import java.util.List;

/**
 * In CreditExternalService we place functions so that we can later implement them
 */

public interface CreditExternalService {
    List<Credit> allCredits();
    Credit saveCredit(Credit credit);
    Credit updateCredit(Credit credit);
    Credit deleteCredit(Long id);
}
