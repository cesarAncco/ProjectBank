package com.nttdata.project.client.application.dto.request;

import com.nttdata.project.client.application.dto.validation.DocumentValidation;
import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * ClientRequest class to validate some fields when sending
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DocumentValidation

/**
 * @NotBlank we indicate that the data or field cannot be empty
 */

public class ClientRequest {
    @NotBlank(message = "The name must not be empty")
    private String name;

    @NotBlank(message = "The last name must not be empty")
    private String lastName;
    private String typeDocument;

    @NotBlank(message = "The document must not be empty")
    private String document;
    private String typeClient;
}
