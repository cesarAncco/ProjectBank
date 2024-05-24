package com.nttdata.project.credit.domain.dto.entity;

import lombok.*;

import javax.persistence.*;

/**
 * CreditTypeEntity.class to be able to give reference to the type of credit to be entered
 * @Id: we indicate that the data will be the id in the database.
 * @GenerateValue: to generate the id with an IDENTITY strategy
 * @Column: to indicate the characteristics of the column in the table
 */

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
