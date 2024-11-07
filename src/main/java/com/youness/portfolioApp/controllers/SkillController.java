package com.youness.portfolioApp.controllers;


import com.youness.portfolioApp.dto.SkillDTO;
import com.youness.portfolioApp.entities.Skill;
import com.youness.portfolioApp.entities.User;
import com.youness.portfolioApp.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillService skillService;


    @GetMapping("/skills")
    public List<SkillDTO> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/skills/{idSkils}")
    public SkillDTO getSkillById(@PathVariable Long idSkils) {
        return skillService.getSkillById(idSkils);
    }

    @PostMapping("/addSkills")
    public Skill createSkill(@RequestBody Skill skill) {
        return skillService.createSkill(skill);
    }

    @PutMapping("/updateSkill/{idSkils}")
    public SkillDTO updateSkill(@PathVariable Long idSkils, @RequestBody SkillDTO skillDTO) {
        skillDTO.setIdSkill(skillDTO.getIdSkill());
        return skillService.updateSkill(idSkils, skillDTO);
    }

    @DeleteMapping("/deleteSkill/{idSkils}")
    public void deleteSkill(@PathVariable Long idSkils) {
        skillService.deleteSkill(idSkils);
    }

}
