package com.nttdata.project.credit.domain.service;

import com.nttdata.project.credit.domain.dto.model.Credit;

import java.util.List;

/**
 * CreditService: interface to reference all the methods to be implemented
 */

public interface CreditService {

    List<Credit> allCredits();
    Credit saveCredit(Credit credit);
    Credit updateCredit(Credit credit);
    Credit deleteCredit(Long id);
}
