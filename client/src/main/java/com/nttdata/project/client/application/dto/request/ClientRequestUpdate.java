package com.nttdata.project.client.application.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * ClientRequestUpdate class to continue validating the fields to update data
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
 * @NotBlank we indicate that the data or field cannot be empty
 */

public class ClientRequestUpdate {

    @NotBlank(message = "The name must not be empty")
    private String name;

    @NotBlank(message = "The last name must not be empty")
    private String lastName;
    private String typeDocument;

    @NotBlank(message = "The document must not be empty")
    private String document;
    private String typeClient;
}
