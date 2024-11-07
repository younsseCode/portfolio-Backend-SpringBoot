package com.youness.portfolioApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExperience;
    private String nomExperience;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public Long getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(Long idExperience) {
        this.idExperience = idExperience;
    }

    public String getNomExperience() {
        return nomExperience;
    }

    public void setNomExperience(String nomExperience) {
        this.nomExperience = nomExperience;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
