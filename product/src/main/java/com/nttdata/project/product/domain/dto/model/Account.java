package com.nttdata.project.product.domain.dto.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private String typeAccount;
    private Long balance;
    private Long commission;
    private Long movements;
    private String headlines;
    private String signatories;
}
