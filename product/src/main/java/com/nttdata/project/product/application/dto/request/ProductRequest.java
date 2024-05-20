package com.nttdata.project.product.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    @NotBlank(message = "The number account must not be empty")
    private String numberAccount;

    private String typeAccount;
    private Long balance;
    private Long transactions;
    private Long commission;
    private String headlines;
    private String signatories;
    private Long movements;
}
