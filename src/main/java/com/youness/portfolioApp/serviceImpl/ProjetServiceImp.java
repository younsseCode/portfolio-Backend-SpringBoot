package com.youness.portfolioApp.serviceImpl;


import com.youness.portfolioApp.dto.ProjetDTO;
import com.youness.portfolioApp.entities.Projet;
import com.youness.portfolioApp.entities.User;
import com.youness.portfolioApp.mapper.ProjetMapper;
import com.youness.portfolioApp.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.youness.portfolioApp.services.ProjectService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProjetServiceImp implements ProjectService {

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired
    private ProjetMapper projetMapper;

    public List<ProjetDTO> getAllProjects() {
        List<Projet> projects = projetRepository.findAll();
        return projects.stream()
                .map(projetMapper::toProjectDTO)
                .collect(Collectors.toList());
    }

    public ProjetDTO getProjectById(Long idProjet) {
        Optional<Projet> projet = projetRepository.findById(idProjet);
        return this.projetMapper.toProjectDTO(projet.get());
    }

    public Projet createProject(Projet projet) {
        return projetRepository.save(projet);
    }

    public ProjetDTO updateProject(Long idProjet, ProjetDTO projectDTO) {
        Projet existingProject = projetRepository.findById(idProjet)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + idProjet));
        // Use the mapper to update only relevant fields from the DTO to the existing entity
        existingProject.setNomProjet( projectDTO.getNomProjet() );
        existingProject.setDescription( projectDTO.getDescription() );
        existingProject.setPhoto( projectDTO.getPhoto() );
        // Save the updated user entity
        Projet savedProject = projetRepository.save(existingProject);
        // Return the updated UserDTO
        return projetMapper.toProjectDTO(savedProject);
    }

    public void deleteProject(Long idProjet) {
        projetRepository.deleteById(idProjet);
    }
}