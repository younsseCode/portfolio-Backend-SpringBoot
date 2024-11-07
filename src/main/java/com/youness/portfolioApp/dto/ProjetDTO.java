package com.youness.portfolioApp.dto;

import java.util.Date;

public class ProjetDTO {
    private Long idProjet;
    private String nomProjet;
    private String description;
    private String[] photo;
    private Date dateProjet;

    public Long getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Long idProjet) {
        this.idProjet = idProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getPhoto() {
        return photo;
    }

    public void setPhoto(String[] photo) {
        this.photo = photo;
    }

    public Date getDateProjet() {
        return dateProjet;
    }

    public void setDateProjet(Date dateProjet) {
        this.dateProjet = dateProjet;
    }
}
