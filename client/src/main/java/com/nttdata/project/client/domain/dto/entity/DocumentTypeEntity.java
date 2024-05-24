package com.nttdata.project.client.domain.dto.entity;

import lombok.*;

import javax.persistence.*;

/**
 *  DocumentTypeEntity.class to be able to give reference to the type of document to be entered
 *  @Id: we indicate that the data will be the id in the database.
 *  @GenerateValue: to generate the id with an IDENTITY strategy
 *  @Column: to indicate the characteristics of the column in the table
 */

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "document_type")
public class DocumentTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="document_name", nullable=false, length=30)
    private String  documentName;
}
