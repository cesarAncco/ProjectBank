package com.nttdata.project.product.application.dto.response;

import lombok.Builder;
import lombok.Data;

/**
 * AccountResponse class to give a personalized response when data is sent
 * message: field to display the message
 * code: field to display the status
 */

@Builder
@Data
public class AccountResponse {
    private String message;
    private String code;
}
