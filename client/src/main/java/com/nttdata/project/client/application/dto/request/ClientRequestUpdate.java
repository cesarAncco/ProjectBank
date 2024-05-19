package com.nttdata.project.client.application.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestUpdate {

    @NotBlank(message = "The name must not be empty")
    private String name;

    @NotBlank(message = "The last name must not be empty")
    private String lastName;
    private String typeDocument;

    @NotBlank(message = "The document must not be empty")
    @Pattern(regexp = "^\\d{8}$", message = "Enter a valid document")
    private String document;
    private String typeClient;
}
