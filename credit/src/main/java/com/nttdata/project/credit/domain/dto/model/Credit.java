package com.nttdata.project.credit.domain.dto.model;

import lombok.*;

/**
 * Credit.class to be used as a model
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Credit {

    private Long id;
    private String typeCredit;
    private Long credits;

}
