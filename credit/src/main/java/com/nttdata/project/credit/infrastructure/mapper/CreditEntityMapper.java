package com.nttdata.project.credit.infrastructure.mapper;

import com.nttdata.project.credit.domain.dto.entity.CreditEntity;
import com.nttdata.project.credit.domain.dto.model.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CreditEntityMapper {

    CreditEntityMapper INSTANCE = Mappers.getMapper(CreditEntityMapper.class);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "typeCredit", source = "typeCredit.creditTypeName")
    @Mapping(target = "credits", source = "credits")
    Credit mapToCredit(CreditEntity creditEntity);

    List<Credit> mapToCredit(List<CreditEntity> creditEntities);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "typeCredit.id", source = "typeCredit")
    @Mapping(target = "credits", source = "credits")
    CreditEntity mapToCreditEntity(Credit credit);

}
