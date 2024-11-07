package com.youness.portfolioApp.services;

import com.youness.portfolioApp.dto.ProjetDTO;
import com.youness.portfolioApp.entities.Projet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    List<ProjetDTO> getAllProjects();

    ProjetDTO getProjectById(Long idProjet);

    Projet createProject(Projet projet);

    ProjetDTO updateProject(Long idProjet, ProjetDTO projectDTO);

    void deleteProject(Long idProjet);

}