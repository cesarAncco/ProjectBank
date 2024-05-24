package com.nttdata.project.credit.application.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * CreditRequestUpdate class to continue validating the fields to update data
 * @NotBlank we indicate that the data or field cannot be empty
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditRequestUpdate {

    @NotBlank(message = "The type credit must not be empty")
    private String typeCredit;

    @NotBlank(message = "The credits must not be empty")
    private String credits;

}
