package com.youness.portfolioApp.mapper;

import com.youness.portfolioApp.dto.SkillDTO;
import com.youness.portfolioApp.entities.Skill;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface SkillMapper {

    //    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    SkillDTO toSkillDTO(Skill skill);

    Skill toSkillEntity(SkillDTO skillDTO);

}
