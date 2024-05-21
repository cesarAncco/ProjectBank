package com.nttdata.project.credit.infrastructure.controller;

import com.nttdata.project.credit.application.dto.request.CreditRequest;
import com.nttdata.project.credit.application.dto.request.CreditRequestUpdate;
import com.nttdata.project.credit.application.dto.response.CreditResponse;
import com.nttdata.project.credit.application.mapper.CreditMapper;
import com.nttdata.project.credit.application.service.CreditExternalServiceCustom;
import com.nttdata.project.credit.domain.dto.model.Credit;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/credit")
@AllArgsConstructor
public class CreditController {

    private final CreditExternalServiceCustom creditExternalServiceCustom;

    @GetMapping(value = "/credits")
    public ResponseEntity<List<Credit>> findClients() {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                creditExternalServiceCustom.allCredits()
        );
    }

    @PostMapping(value = "/create")
    public ResponseEntity<CreditResponse> saveClient(@Valid @RequestBody CreditRequest creditRequest) {
        creditExternalServiceCustom.saveCredit(CreditMapper.INSTANCE.mapToCredit(creditRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(
                CreditResponse.builder()
                        .code("201")
                        .message("Registered Credit")
                        .build()

        );
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<CreditResponse> updateClient(@PathVariable("id") Long id, @Valid @RequestBody CreditRequestUpdate creditRequestUpdate) {

        creditExternalServiceCustom.updateCredit(CreditMapper.INSTANCE.mapToCreditUpdate(id, creditRequestUpdate));

        return ResponseEntity.status(HttpStatus.OK).body(
                CreditResponse.builder()
                        .code("200")
                        .message("Updated Credit")
                        .build()

        );
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<CreditResponse> deleteClient(@PathVariable("id") Long id) {
        creditExternalServiceCustom.deleteCredit(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                CreditResponse.builder()
                        .code("200")
                        .message("Deleted Credit")
                        .build()

        );
    }
}
