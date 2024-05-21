package com.nttdata.project.credit.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreditResponse {
    private String message;
    private String code;
}
