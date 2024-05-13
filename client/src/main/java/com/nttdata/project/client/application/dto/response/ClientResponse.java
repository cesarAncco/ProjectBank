package com.nttdata.project.client.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientResponse {
    private String message;
    private String code;
}
