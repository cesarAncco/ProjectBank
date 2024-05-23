package com.nttdata.project.product.util;

import com.nttdata.project.product.application.dto.request.AccountRequest;
import com.nttdata.project.product.application.dto.request.AccountRequestUpdate;
import com.nttdata.project.product.domain.dto.entity.AccountEntity;
import com.nttdata.project.product.domain.dto.entity.AccountTypeEntity;
import com.nttdata.project.product.domain.dto.model.Account;

import java.util.List;

public class util {

    public static Account createAccount() {
        return Account.builder()
                .id(1L)
                .typeAccount("1")
                .balance(1000L)
                .commission(100L)
                .movements(10L)
                .headlines("Cesar")
                .signatories("Cesar")
                .build();
    }

    public static List<Account> createAccountList() {
        return List.of(Account.builder()
                .id(1L)
                .typeAccount("1")
                .balance(1000L)
                .commission(100L)
                .movements(10L)
                .headlines("Cesar")
                .signatories("Cesar")
                .build());
    }


    public static AccountEntity createAccountEntity() {
        return AccountEntity.builder()
                .id(1L)
                .typeAccount(AccountTypeEntity.builder().id(1L).accountTypeName("AHORRO").build())
                .balance(1000L)
                .commission(100L)
                .movements(10L)
                .headlines("Cesar")
                .signatories("Cesar")
                .build();
    }

    public static List<AccountEntity> createAccountEntityList() {
        return List.of(AccountEntity.builder()
                .id(1L)
                .typeAccount(AccountTypeEntity.builder().id(1L).accountTypeName("AHORRO").build())
                .balance(1000L)
                .commission(100L)
                .movements(10L)
                .headlines("Cesar")
                .signatories("Cesar")
                .build());
    }

    public static AccountRequest createAccountRequest() {
        return AccountRequest.builder()
                .typeAccount("1")
                .balance("1000")
                .commission("100")
                .movements("10")
                .headlines("Cesar")
                .signatories("Cesar")
                .build();
    }

    public static AccountRequestUpdate createAccountRequestUpdate() {
        return AccountRequestUpdate.builder()
                .typeAccount("1")
                .balance("1000")
                .commission("100")
                .movements("10")
                .headlines("Cesar")
                .signatories("Cesar")
                .build();
    }

}
