package com.nttdata.project.product.domain.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

/**
 * AccountEntity.class we indicate all the fields to be able to create an Account
 * @Entity: we indicate that it is an entity
 * @Table: we indicate the reference to the table in the database.
 * @Id: we indicate that the data will be the id in the database.
 * @GenerateValue: to generate the id with an IDENTITY strategy
 * @Column: to indicate the characteristics of the column in the table
 * @ManyToOne: To define a many-to-one relationship in JPA.
 * @JoinColumn: Specify the database column to use
 */

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name="type_account")
    private AccountTypeEntity typeAccount;

    private Long balance;
    private Long commission;
    private Long movements;
    private String headlines;
    private String signatories;
}
