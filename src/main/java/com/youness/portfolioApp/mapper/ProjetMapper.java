package com.youness.portfolioApp.mapper;

import com.youness.portfolioApp.dto.ProjetDTO;
import com.youness.portfolioApp.entities.Projet;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ProjetMapper {

    ProjetDTO toProjectDTO(Projet project);

    Projet toProject(ProjetDTO dto);
}
