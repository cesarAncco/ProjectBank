package com.nttdata.project.credit.application.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * CreditRequest class to validate some fields when sending
 * @NotBlank we indicate that the data or field cannot be empty
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditRequest {

    @NotBlank(message = "The type credit must not be empty")
    private String typeCredit;

    @NotBlank(message = "The credits must not be empty")
    private String credits;
}
