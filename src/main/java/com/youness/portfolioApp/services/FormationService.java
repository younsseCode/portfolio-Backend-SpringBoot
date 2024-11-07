package com.youness.portfolioApp.services;

import com.youness.portfolioApp.dto.FormationDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FormationService {


    List<FormationDTO> getAllFormations();

    FormationDTO getFormationById(Long idFormation);

    FormationDTO createFormation(FormationDTO formationDTO);

    FormationDTO updateFormation(FormationDTO formationDTO);

    void deleteFormation(Long idFormation);
}