package com.nttdata.project.credit.util;

import com.nttdata.project.credit.application.dto.request.CreditRequest;
import com.nttdata.project.credit.application.dto.request.CreditRequestUpdate;
import com.nttdata.project.credit.domain.dto.entity.CreditEntity;
import com.nttdata.project.credit.domain.dto.entity.CreditTypeEntity;
import com.nttdata.project.credit.domain.dto.model.Credit;

import java.util.List;

public class util {

    public static Credit createCredit() {
        return Credit.builder()
                .id(1L)
                .typeCredit("1")
                .credits(100L)
                .build();
    }

    public static List<Credit> createCreditList() {
        return List.of(Credit.builder()
                .id(1L)
                .typeCredit("1")
                .credits(100L)
                .build());
    }


    public static CreditEntity createCreditEntity() {
        return CreditEntity.builder()
                .id(1L)
                .typeCredit(CreditTypeEntity.builder().id(1L).creditTypeName("PERSONAL").build())
                .credits(100L)
                .build();
    }

    public static List<CreditEntity> createCreditEntityList() {
        return List.of(CreditEntity.builder()
                .id(1L)
                .typeCredit(CreditTypeEntity.builder().id(1L).creditTypeName("PERSONAL").build())
                .credits(100L)
                .build());
    }

    public static CreditRequest createCreditRequest() {
        return CreditRequest.builder()
                .typeCredit("1")
                .credits("100")
                .build();
    }

    public static CreditRequestUpdate createCreditRequestUpdate() {
        return CreditRequestUpdate.builder()
                .typeCredit("1")
                .credits("100")
                .build();
    }
}
