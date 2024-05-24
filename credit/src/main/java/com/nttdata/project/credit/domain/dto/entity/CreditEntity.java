package com.nttdata.project.credit.domain.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

/**
 * CreditEntity.class we indicate all the fields to be able to create a Credit
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
@Table(name = "credits")
public class CreditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "type_credit")
    private CreditTypeEntity typeCredit;
    private Long credits;
}
