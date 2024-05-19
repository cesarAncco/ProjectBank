package com.nttdata.project.client.application.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

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
    private String document;
    private String typeClient;
}
