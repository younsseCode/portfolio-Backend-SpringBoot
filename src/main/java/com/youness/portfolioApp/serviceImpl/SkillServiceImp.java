package com.youness.portfolioApp.serviceImpl;

import com.youness.portfolioApp.dto.SkillDTO;
import com.youness.portfolioApp.entities.Skill;
import com.youness.portfolioApp.mapper.SkillMapper;
import com.youness.portfolioApp.repositories.SkillRepository;
import com.youness.portfolioApp.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SkillServiceImp implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillMapper skillMapper;

    @Override
    public List<SkillDTO> getAllSkills() {
        List<Skill> skills = skillRepository.findAll();
        return skills.stream().map(skillMapper::toSkillDTO).collect(Collectors.toList());
    }

    @Override
    public SkillDTO getSkillById(Long idSkill) {
        Optional<Skill> skill = skillRepository.findById(idSkill);
        return this.skillMapper.toSkillDTO(skill.get());
    }

    @Override
    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public SkillDTO updateSkill(Long idSkill, SkillDTO skillDTO) {
        // Fetch the existing user from the database
        Skill existingSkill = skillRepository.findById(idSkill)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + idSkill));
        // Use the mapper to update only relevant fields from the DTO to the existing entity
        existingSkill.setNameSkill( skillDTO.getNameSkill() );
//        // Save the updated user entity
        Skill saveSkill = skillRepository.save(existingSkill);
        // Return the updated UserDTO
        return skillMapper.toSkillDTO(saveSkill);

    }

    @Override
    public void deleteSkill(Long idSkill) {
        skillRepository.deleteById(idSkill);
    }
}
