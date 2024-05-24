package com.nttdata.project.credit.application.mapper;

import com.nttdata.project.credit.application.dto.request.CreditRequest;
import com.nttdata.project.credit.application.dto.request.CreditRequestUpdate;
import com.nttdata.project.credit.domain.dto.model.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * CreditMapper interface to be able to map requests
 * mapToCredit: to map from CreditRequest to Credit
 * mapToCreditUpdate: to map from CreditRequestUpdate to Credit
 */

@Mapper
public interface CreditMapper {
    CreditMapper INSTANCE = Mappers.getMapper(CreditMapper.class);

    default Credit mapToCredit(CreditRequest creditRequest) {
        return Credit.builder()
                .typeCredit(creditRequest.getTypeCredit())
                .credits(Long.parseLong(creditRequest.getCredits()))
                .build();
    }

    default Credit mapToCreditUpdate(Long id, CreditRequestUpdate creditRequestUpdate) {
        return Credit.builder()
                .id(id)
                .typeCredit(creditRequestUpdate.getTypeCredit())
                .credits(Long.parseLong(creditRequestUpdate.getCredits()))
                .build();
    }
}
