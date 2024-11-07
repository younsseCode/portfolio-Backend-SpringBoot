package com.youness.portfolioApp.serviceImpl;

import com.youness.portfolioApp.dto.CompetenceDTO;
import com.youness.portfolioApp.entities.Competence;
import com.youness.portfolioApp.mapper.CompetenceMapper;
import com.youness.portfolioApp.repositories.CompetenceRepository;
import com.youness.portfolioApp.services.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetenceServiceImp implements CompetenceService {

    @Autowired
    private CompetenceRepository competenceRepository;

    @Autowired
    private CompetenceMapper competenceMapper;


    public List<CompetenceDTO> getAllCompetences() {
        List<Competence> competences = competenceRepository.findAll();
        return competences.stream().map(competenceMapper::toCompetenceDTO).collect(Collectors.toList());
    }

    public CompetenceDTO getCompetenceById(Long idCompetence) {
        Competence competence = competenceRepository.findById(idCompetence).orElseThrow();
        return competenceMapper.toCompetenceDTO(competence);
    }

    public CompetenceDTO createCompetence(CompetenceDTO competenceDTO) {
        Competence competence = competenceMapper.toCompetenceEntity(competenceDTO);
        Competence savedCompetence = competenceRepository.save(competence);
        return competenceMapper.toCompetenceDTO(savedCompetence);
    }

    public CompetenceDTO updateCompetence(CompetenceDTO competenceDTO) {
//        Competence competence = competenceRepository.findById(competenceDTO.getIdCompetence()).orElseThrow();
//        competenceMapper.toCompetence(competenceDTO, competence);
//        Competence savedCompetence = competenceRepository.save(competence);
//        return competenceMapper.toCompetenceDTO(savedCompetence);
        return null;
    }

    public void deleteCompetence(Long idCompetence) {
        competenceRepository.deleteById(idCompetence);
    }
}