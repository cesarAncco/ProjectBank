package com.nttdata.project.product.application.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * AccountRequest class to validate some fields when sending
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
 * @NotBlank we indicate that the data or field cannot be empty
 */

public class AccountRequest {

    @NotBlank(message = "The type account must not be empty")
    private String typeAccount;
    private String balance;

    @NotBlank(message = "The commission must not be empty")
    private String commission;
    private String movements;

    @NotBlank(message = "The headlines must not be empty")
    private String headlines;

    @NotBlank(message = "The signatories must not be empty")
    private String signatories;
}
