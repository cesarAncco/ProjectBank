package com.nttdata.project.product.domain.dto.entity;

import lombok.*;

import javax.persistence.*;

/**
 * AccountTypeEntity.class to be able to give reference to the type of account to be entered
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
@Table(name = "account_type")
public class AccountTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="account_type_name", nullable=false, length=30)
    private String  accountTypeName;
}
