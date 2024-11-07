package com.youness.portfolioApp.services;

import com.youness.portfolioApp.dto.ExperienceDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExperienceService {

    List<ExperienceDTO> getAllExperiences();

    ExperienceDTO getExperienceById(Long idExperience);

    ExperienceDTO createExperience(ExperienceDTO experienceDTO);

    ExperienceDTO updateExperience(ExperienceDTO experienceDTO);

    void deleteExperience(Long idExperience);
}