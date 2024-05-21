package com.nttdata.project.credit.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditRequestUpdate {

    @NotBlank(message = "The type credit must not be empty")
    private String typeCredit;

    @NotBlank(message = "The credits must not be empty")
    private Long credits;

}
