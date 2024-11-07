package com.youness.portfolioApp.controllers;

import com.youness.portfolioApp.dto.ProjetDTO;
import com.youness.portfolioApp.entities.Projet;
import com.youness.portfolioApp.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")  // Autoriser les requêtes depuis Angular

@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<ProjetDTO> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/projects/{idProjet}")
    public ProjetDTO getProjectById(@PathVariable Long idProjet) {
        return projectService.getProjectById(idProjet);
    }


//    @PostMapping("/addProjects")
//    public Projet createProject(@RequestBody Projet projet) {
//        return projectService.createProject(projet);
//    }

    @PostMapping("/createProject")
    public Projet addProject(@RequestBody Projet projet) {
        return projectService.createProject(projet);
    }

    @PutMapping("/update/{idProjet}")
    public ProjetDTO updateProject(@PathVariable Long idProjet, @RequestBody ProjetDTO projectDTO) {
        projectDTO.setIdProjet(projectDTO.getIdProjet());
        return projectService.updateProject(idProjet,projectDTO);
    }

    @DeleteMapping("/deleteProject/{idProjet}")
    public void deleteProject(@PathVariable Long idProjet){
        projectService.deleteProject(idProjet);
    }
}
