package com.nttdata.project.product.application.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * AccountRequestUpdate class to continue validating the fields to update data
 * @NotBlank we indicate that the data or field cannot be empty
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountRequestUpdate {

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
