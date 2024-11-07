package com.youness.portfolioApp.mapper;

import com.youness.portfolioApp.dto.ExperienceDTO;
import com.youness.portfolioApp.entities.Experience;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ExperienceMapper {

    ExperienceDTO toExperienceDTO(Experience experience);

    Experience toExperience(ExperienceDTO experienceDTO);}
