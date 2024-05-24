package com.nttdata.project.credit.domain.repository;

import com.nttdata.project.credit.domain.dto.model.Credit;

import java.util.List;

/**
 * CreditRepository: the interface will refer to all the methods that will be implemented
 */

public interface CreditRepository {

    List<Credit> allCredits();
    Credit saveCredit(Credit credit);
    Credit updateCredit(Credit credit);
    Credit deleteCredit(Long id);
}
