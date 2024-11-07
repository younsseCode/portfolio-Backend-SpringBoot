package com.youness.portfolioApp.controllers;

import com.youness.portfolioApp.dto.ExperienceDTO;
import com.youness.portfolioApp.services.ExperienceService;
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
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping("/experiences")
    public ResponseEntity<List<ExperienceDTO>> getAllExperiences() {
        List<ExperienceDTO> experiences = experienceService.getAllExperiences();
        return new ResponseEntity<>(experiences, HttpStatus.OK);
    }

    @GetMapping("/experiences/{idExperience}")
    public ResponseEntity<ExperienceDTO> getExperienceById(@PathVariable Long idExperience) {
        ExperienceDTO experience = experienceService.getExperienceById(idExperience);
        return new ResponseEntity<>(experience, HttpStatus.OK);
    }

    @PostMapping("/addExperience")
    public ResponseEntity<ExperienceDTO> createExperience(@RequestBody ExperienceDTO experienceDTO) {
        ExperienceDTO createdExperience = experienceService.createExperience(experienceDTO);
        return new ResponseEntity<>(createdExperience, HttpStatus.CREATED);
    }

    @PutMapping("/update/{idExperience}")
    public ResponseEntity<ExperienceDTO> updateExperience(@PathVariable Long idExperience, @RequestBody ExperienceDTO experienceDTO) {
        ExperienceDTO updatedExperience = experienceService.updateExperience(experienceDTO);
        return new ResponseEntity<>(updatedExperience, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idExperience}")
    public ResponseEntity<String> deleteExperience(@PathVariable Long idExperience) {
        experienceService.deleteExperience(idExperience);
        return new ResponseEntity<>("Experience deleted", HttpStatus.OK);
    }
}
