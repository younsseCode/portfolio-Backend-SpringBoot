package com.youness.portfolioApp.repositories;

import com.youness.portfolioApp.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

//    @Query("SELECT s FROM Skill s WHERE s.nameSkils = :nameSkils")
//    Skill findByNameSkils(@Param("nameSkils") String nameSkils);
//
//    @Query("SELECT s FROM Skill s WHERE s.user.idUser = :idUser")
//    List<Skill> findByUser(@Param("idUser") Long idUser);
}