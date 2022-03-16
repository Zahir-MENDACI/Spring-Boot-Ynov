package com.ynov.medical.patientws.models;

public class Pathologie {
    Integer id;
    String nom;
    String gravite;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getGravite() {
        return gravite;
    }
    public void setGravite(String gravite) {
        this.gravite = gravite;
    }
}
