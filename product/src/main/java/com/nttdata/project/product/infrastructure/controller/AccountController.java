package com.nttdata.project.product.infrastructure.controller;

import com.nttdata.project.product.application.dto.request.AccountRequest;
import com.nttdata.project.product.application.dto.request.AccountRequestUpdate;
import com.nttdata.project.product.application.dto.response.AccountResponse;
import com.nttdata.project.product.application.mapper.AccountMapper;
import com.nttdata.project.product.application.service.AccountExternalServiceCustom;
import com.nttdata.project.product.domain.dto.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/account")
@AllArgsConstructor
public class AccountController {

    private final AccountExternalServiceCustom accountExternalServiceCustom;

    @GetMapping(value = "/accounts")
    public ResponseEntity<List<Account>> findClients() {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                accountExternalServiceCustom.allAccounts()
        );
    }

    @PostMapping(value = "/create")
    public ResponseEntity<AccountResponse> saveClient(@Valid @RequestBody AccountRequest accountRequest) {
        accountExternalServiceCustom.saveAccount(AccountMapper.INSTANCE.mapToAccount(accountRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(
                AccountResponse.builder()
                        .code("201")
                        .message("Registered Account")
                        .build()

        );
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<AccountResponse> updateClient(@PathVariable("id") Long id, @Valid @RequestBody AccountRequestUpdate accountRequestUpdate) {

        accountExternalServiceCustom.updateAccount(AccountMapper.INSTANCE.mapToAccountUpdate(id, accountRequestUpdate));

        return ResponseEntity.status(HttpStatus.OK).body(
                AccountResponse.builder()
                        .code("200")
                        .message("Updated Account")
                        .build()

        );
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<AccountResponse> deleteClient(@PathVariable("id") Long id) {
        accountExternalServiceCustom.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                AccountResponse.builder()
                        .code("200")
                        .message("Deleted Account")
                        .build()

        );
    }
}
