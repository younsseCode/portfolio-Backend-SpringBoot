package com.youness.portfolioApp.mapper;

import com.youness.portfolioApp.dto.FormationDTO;
import com.youness.portfolioApp.entities.Formation;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface FormationMapper {

    FormationDTO toFormationDTO(Formation formation);

    Formation toFormation(FormationDTO formationDTO);}
