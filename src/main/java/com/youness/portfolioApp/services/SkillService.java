package com.youness.portfolioApp.services;

import com.youness.portfolioApp.dto.SkillDTO;
import com.youness.portfolioApp.entities.Skill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SkillService {

    List<SkillDTO> getAllSkills();

    SkillDTO getSkillById(Long idSkils);

    Skill createSkill(Skill skill);

    SkillDTO updateSkill(Long idSkils, SkillDTO skillDTO);

    void deleteSkill(Long idSkils);

}