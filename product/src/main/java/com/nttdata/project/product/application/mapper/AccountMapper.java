package com.nttdata.project.product.application.mapper;

import com.nttdata.project.product.application.dto.request.AccountRequest;
import com.nttdata.project.product.application.dto.request.AccountRequestUpdate;
import com.nttdata.project.product.domain.dto.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * AccountMapper interface to be able to map requests
 * mapToAccount: to map from AccountRequest to Account
 * mapToAccountUpdate: to map from AccountRequestUpdate to Account
 */

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    default Account mapToAccount(AccountRequest accountRequest) {
        return Account.builder()
                .typeAccount(accountRequest.getTypeAccount())
                .balance(Long.parseLong(accountRequest.getBalance()))
                .commission(Long.parseLong(accountRequest.getCommission()))
                .movements(Long.parseLong(accountRequest.getMovements()))
                .headlines(accountRequest.getHeadlines())
                .signatories(accountRequest.getSignatories())
                .build();
    }

    default Account mapToAccountUpdate(Long id, AccountRequestUpdate accountRequestUpdate) {
        return Account.builder()
                .id(id)
                .typeAccount(accountRequestUpdate.getTypeAccount())
                .balance(Long.parseLong(accountRequestUpdate.getBalance()))
                .commission(Long.parseLong(accountRequestUpdate.getCommission()))
                .movements(Long.parseLong(accountRequestUpdate.getMovements()))
                .headlines(accountRequestUpdate.getHeadlines())
                .signatories(accountRequestUpdate.getSignatories())
                .build();
    }
}
