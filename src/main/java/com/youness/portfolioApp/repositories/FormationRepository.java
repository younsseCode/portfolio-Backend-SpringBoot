package com.youness.portfolioApp.repositories;
import com.youness.portfolioApp.entities.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

//    @Query("SELECT f FROM Formation f WHERE f.nomFormation = :nomFormation")
//    Formation findByNomFormation(@Param("nomFormation") String nomFormation);
//
//    @Query("SELECT f FROM Formation f WHERE f.user.idUser = :idUser")
//    List<Formation> findByUser(@Param("idUser") Long idUser);
}