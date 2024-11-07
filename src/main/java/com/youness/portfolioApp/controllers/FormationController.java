package com.youness.portfolioApp.controllers;

import com.youness.portfolioApp.dto.FormationDTO;
import com.youness.portfolioApp.services.FormationService;
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
public class FormationController {

    @Autowired
    private FormationService formationService;

    @GetMapping("/formations")
    public ResponseEntity<List<FormationDTO>> getAllFormations() {
        List<FormationDTO> formations = formationService.getAllFormations();
        return new ResponseEntity<>(formations, HttpStatus.OK);
    }

    @GetMapping("/formations/{idFormation}")
    public ResponseEntity<FormationDTO> getFormationById(@PathVariable Long idFormation) {
        FormationDTO formation = formationService.getFormationById(idFormation);
        return new ResponseEntity<>(formation, HttpStatus.OK);
    }

    @PostMapping("/addFormations")
    public ResponseEntity<FormationDTO> createFormation(@RequestBody FormationDTO formationDTO) {
        FormationDTO createdFormation = formationService.createFormation(formationDTO);
        return new ResponseEntity<>(createdFormation, HttpStatus.CREATED);
    }

    @PutMapping("/update/{idFormation}")
    public ResponseEntity<FormationDTO> updateFormation(@PathVariable Long idFormation, @RequestBody FormationDTO formationDTO) {
        FormationDTO updatedFormation = formationService.updateFormation(formationDTO);
        return new ResponseEntity<>(updatedFormation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idFormation}")
    public ResponseEntity<String> deleteFormation(@PathVariable Long idFormation) {
        formationService.deleteFormation(idFormation);
        return new ResponseEntity<>("Formation deleted", HttpStatus.OK);
    }
}
