package com.youness.portfolioApp.repositories;

import com.youness.portfolioApp.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {

//    @Query("SELECT e FROM Experience e WHERE e.nomExperience = :nomExperience")
//    Experience findByNomExperience(@Param("nomExperience") String nomExperience);
//
//    @Query("SELECT e FROM Experience e WHERE e.user.idUser = :idUser")
//    List<Experience> findByUser(@Param("idUser") Long idUser);
}