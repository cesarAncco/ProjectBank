package com.nttdata.project.credit.domain.repository;

import com.nttdata.project.credit.domain.dto.model.Credit;

import java.util.List;

public interface CreditRepository {

    List<Credit> allCredits();
    Credit saveCredit(Credit credit);
    Credit updateCredit(Credit credit);
    Credit deleteCredit(Long id);
}
