package com.nttdata.project.client.domain.dto.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private Long id;
    private String name;
    private String lastName;
    private String typeDocument;
    private String document;
    private String typeClient;

}
