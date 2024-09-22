package com.Project.SpringAngular.DTO;


import jakarta.persistence.Column;

public class serviceDTO {

    private int id;
    private String nom;


    public serviceDTO(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public serviceDTO() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "serviceDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
