package com.youness.portfolioApp.controllers;

import com.youness.portfolioApp.dto.CompetenceDTO;
import com.youness.portfolioApp.services.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CompetenceController {

    @Autowired
    private CompetenceService competenceService;

    @GetMapping("/competences")
    public ResponseEntity<List<CompetenceDTO>> getAllCompetences() {
        List<CompetenceDTO> competences = competenceService.getAllCompetences();
        return new ResponseEntity<>(competences, HttpStatus.OK);
    }

    @GetMapping("/competences/{idCompetence}")
    public ResponseEntity<CompetenceDTO> getCompetenceById(@PathVariable Long idCompetence) {
        CompetenceDTO competence = competenceService.getCompetenceById(idCompetence);
        return new ResponseEntity<>(competence, HttpStatus.OK);
    }

    @PostMapping("/addCompetences")
    public ResponseEntity<CompetenceDTO> createCompetence(@RequestBody CompetenceDTO competenceDTO) {
        CompetenceDTO createdCompetence = competenceService.createCompetence(competenceDTO);
        return new ResponseEntity<>(createdCompetence, HttpStatus.CREATED);
    }

    @PutMapping("/update/{idCompetence}")
    public ResponseEntity<CompetenceDTO> updateCompetence(@PathVariable Long idCompetence, @RequestBody CompetenceDTO competenceDTO) {
        CompetenceDTO updatedCompetence = competenceService.updateCompetence(competenceDTO);
        return new ResponseEntity<>(updatedCompetence, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idCompetence}")
    public ResponseEntity<String> deleteCompetence(@PathVariable Long idCompetence) {
        competenceService.deleteCompetence(idCompetence);
        return new ResponseEntity<>("Competence deleted", HttpStatus.OK);
    }
}
