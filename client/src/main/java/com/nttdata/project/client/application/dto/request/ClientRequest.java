package com.nttdata.project.client.application.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequest {
    @NotBlank(message = "Debe ingresar un nombre")
    private String name;

    @NotBlank(message = "Debe ingresar un apellido")
    private String lastname;
    private String typeDocument;

    @Pattern(regexp = "^\\d{8}$", message = "Ingrese un documento valido")
    private String document;
    private String typeClient;
}
