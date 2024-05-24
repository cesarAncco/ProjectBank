package com.nttdata.project.client.application.dto.response;

import lombok.Builder;
import lombok.Data;

/**
 * ClientResponse class to give a personalized response when data is sent
 */

@Builder
@Data

/**
 * message: field to display the message
 * code: field to display the status
 */

public class ClientResponse {
    private String message;
    private String code;
}
