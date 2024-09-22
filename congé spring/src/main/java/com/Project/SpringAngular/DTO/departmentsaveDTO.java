package com.Project.SpringAngular.DTO;



public class departmentsaveDTO {

    private int id;
    private String nom;

    public departmentsaveDTO() {
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
        return "departmentsaveDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
