package com.nttdata.project.credit.application.dto.response;

import lombok.Builder;
import lombok.Data;

/**
 * CreditResponse class to give a personalized response when data is sent
 * message: field to display the message
 * code: field to display the status
 */

@Builder
@Data
public class CreditResponse {
    private String message;
    private String code;
}
