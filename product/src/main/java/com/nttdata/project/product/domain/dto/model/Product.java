package com.nttdata.project.product.domain.dto.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String numberAccount;
    private String typeAccount;
    private Long balance;
    private Long transactions;
    private Long commission;
    private String headlines;
    private String signatories;
    private Long movements;
}
