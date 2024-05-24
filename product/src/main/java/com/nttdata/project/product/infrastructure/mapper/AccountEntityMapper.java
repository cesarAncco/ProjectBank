package com.nttdata.project.product.infrastructure.mapper;

import com.nttdata.project.product.domain.dto.entity.AccountEntity;
import com.nttdata.project.product.domain.dto.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * AccountEntityMapper interface to be able to map Entities
 * mapToAccount: to map from AccountEntity to Account
 * mapToAccountEntity: to map from Account to AccountEntity
 */

@Mapper
public interface AccountEntityMapper {

    AccountEntityMapper INSTANCE = Mappers.getMapper(AccountEntityMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "typeAccount", source = "typeAccount.accountTypeName")
    @Mapping(target = "balance", source = "balance")
    @Mapping(target = "commission", source = "commission")
    @Mapping(target = "movements", source = "movements")
    @Mapping(target = "headlines", source = "headlines")
    @Mapping(target = "signatories", source = "signatories")
    Account mapToAccount(AccountEntity accountEntity);

    List<Account> mapToAccount(List<AccountEntity> accountEntities);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "typeAccount.id", source = "typeAccount")
    @Mapping(target = "balance", source = "balance")
    @Mapping(target = "commission", source = "commission")
    @Mapping(target = "movements", source = "movements")
    @Mapping(target = "headlines", source = "headlines")
    @Mapping(target = "signatories", source = "signatories")
    AccountEntity mapToAccountEntity(Account account);


}
