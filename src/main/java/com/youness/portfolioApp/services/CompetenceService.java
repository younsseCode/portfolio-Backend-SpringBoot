package com.youness.portfolioApp.services;

import com.youness.portfolioApp.dto.CompetenceDTO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CompetenceService {


    List<CompetenceDTO> getAllCompetences();

    CompetenceDTO getCompetenceById(Long idCompetence);

    CompetenceDTO createCompetence(CompetenceDTO competenceDTO);

    CompetenceDTO updateCompetence(CompetenceDTO competenceDTO) ;

    void deleteCompetence(Long idCompetence);
}