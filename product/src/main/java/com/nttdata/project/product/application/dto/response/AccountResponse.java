package com.nttdata.project.product.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AccountResponse {
    private String message;
    private String code;
}
