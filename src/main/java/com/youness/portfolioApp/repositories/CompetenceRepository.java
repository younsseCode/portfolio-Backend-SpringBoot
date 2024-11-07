package com.youness.portfolioApp.repositories;

import com.youness.portfolioApp.entities.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence, Long> {

//    @Query("SELECT c FROM Competence c WHERE c.nomCompetence = :nomCompetence")
//    Competence findByNomCompetence(@Param("nomCompetence") String nomCompetence);
//
//    @Query("SELECT c FROM Competence c WHERE c.user.idUser = :idUser")
//    List<Competence> findByUser(@Param("idUser") Long idUser);
}