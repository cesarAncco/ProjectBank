package com.nttdata.project.credit.application.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

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
