package com.youness.portfolioApp.serviceImpl;

import com.youness.portfolioApp.dto.FormationDTO;
import com.youness.portfolioApp.entities.Formation;
import com.youness.portfolioApp.mapper.FormationMapper;
import com.youness.portfolioApp.repositories.FormationRepository;
import com.youness.portfolioApp.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormationServiceImp implements FormationService {

    @Autowired
    private FormationRepository formationRepository;

    @Autowired
    private FormationMapper formationMapper;

    public List<FormationDTO> getAllFormations() {
        List<Formation> formations = formationRepository.findAll();
        return formations.stream().map(formationMapper::toFormationDTO).collect(Collectors.toList());
    }

    public FormationDTO getFormationById(Long idFormation) {
        Formation formation = formationRepository.findById(idFormation).orElseThrow();
        return formationMapper.toFormationDTO(formation);
    }

    public FormationDTO createFormation(FormationDTO formationDTO) {
        Formation formation = formationMapper.toFormation(formationDTO);
        Formation savedFormation = formationRepository.save(formation);
        return formationMapper.toFormationDTO(savedFormation);
    }

    public FormationDTO updateFormation(FormationDTO formationDTO) {
//        Formation formation = formationRepository.findById(formationDTO.getIdFormation()).orElseThrow();
//        formationMapper.toFormation(formationDTO, formation);
//        Formation savedFormation = formationRepository.save(formation);
//        return formationMapper.toFormationDTO(savedFormation);
        return null;
    }

    public void deleteFormation(Long idFormation) {
        formationRepository.deleteById(idFormation);
    }
}