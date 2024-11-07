package com.youness.portfolioApp.mapper;

import com.youness.portfolioApp.dto.CompetenceDTO;
import com.youness.portfolioApp.entities.Competence;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CompetenceMapper {

    CompetenceDTO toCompetenceDTO(Competence competence);

    Competence toCompetenceEntity(CompetenceDTO dto);

}
