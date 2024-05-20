package com.nttdata.project.product.domain.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="number_account", nullable=false, length=255)
    private String numberAccount;

    //@ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "type_account")
    private String typeAccount;
    private Long balance;
    private Long transactions;
    private Long commission;
    private String headlines;
    private String signatories;
    private Long movements;
}
