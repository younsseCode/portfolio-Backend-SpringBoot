package com.youness.portfolioApp.serviceImpl;

import com.youness.portfolioApp.dto.ExperienceDTO;
import com.youness.portfolioApp.entities.Experience;
import com.youness.portfolioApp.mapper.ExperienceMapper;
import com.youness.portfolioApp.repositories.ExperienceRepository;
import com.youness.portfolioApp.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ExperienceServiceImp implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private ExperienceMapper experienceMapper;

    public List<ExperienceDTO> getAllExperiences() {
        List<Experience> experiences = experienceRepository.findAll();
        return experiences.stream().map(experienceMapper::toExperienceDTO).collect(Collectors.toList());
    }

    public ExperienceDTO getExperienceById(Long idExperience) {
        Experience experience = experienceRepository.findById(idExperience).orElseThrow();
        return experienceMapper.toExperienceDTO(experience);
    }

    public ExperienceDTO createExperience(ExperienceDTO experienceDTO) {
        Experience experience = experienceMapper.toExperience(experienceDTO);
        Experience savedExperience = experienceRepository.save(experience);
        return experienceMapper.toExperienceDTO(savedExperience);
    }

    public ExperienceDTO updateExperience(ExperienceDTO experienceDTO) {
//        Experience experience = experienceRepository.findById(experienceDTO.getIdExperience()).orElseThrow();
//        experienceMapper.toExperience(experienceDTO, experience);
//        Experience savedExperience = experienceRepository.save(experience);
//        return experienceMapper.toExperienceDTO(savedExperience);
        return null;
    }

    public void deleteExperience(Long idExperience) {
        experienceRepository.deleteById(idExperience);
    }
}