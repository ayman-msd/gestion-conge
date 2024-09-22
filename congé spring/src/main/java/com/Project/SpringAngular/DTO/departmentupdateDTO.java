package com.Project.SpringAngular.DTO;


public class departmentupdateDTO {


    private int id;
    private String nom;

    public departmentupdateDTO(int id, String nom, int nbr_emp, String sites, String services, String ceo) {
        this.id = id;
        this.nom = nom;
    }

    public departmentupdateDTO() {
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
        return "departmentupdateDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
