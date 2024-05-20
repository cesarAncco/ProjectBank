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

    @NotBlank(message = "The type account must not be empty")
    private String typeAccount;
    private Long balance;

    @NotBlank(message = "The commission must not be empty")
    private Long commission;
    private Long movements;

    @NotBlank(message = "The headlines must not be empty")
    private String headlines;

    @NotBlank(message = "The signatories must not be empty")
    private String signatories;
}