package com.nttdata.project.client.domain.dto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

/**
 * ClientEntity.class we indicate all the fields to be able to create a Client
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
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable=false, length=255)
    private String name;

    @Column(name = "lastname", nullable=false, length=255)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "type_document")
    private DocumentTypeEntity typeDocument;

    @Column(name="document", nullable=false, length=30)
    private String document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "type_client")
    private ClientTypeEntity typeClient;
}
