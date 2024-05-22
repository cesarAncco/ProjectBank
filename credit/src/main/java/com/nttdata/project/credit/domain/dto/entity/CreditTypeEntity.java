package com.nttdata.project.credit.domain.dto.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "credit_type")
public class CreditTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="credit_type_name", nullable=false, length=30)
    private String  creditTypeName;
}
