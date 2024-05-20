package com.nttdata.project.product.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductResponse {
    private String message;
    private String code;
}
