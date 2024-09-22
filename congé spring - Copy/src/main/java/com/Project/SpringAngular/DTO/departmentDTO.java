package com.Project.SpringAngular.DTO;


public class departmentDTO {

    private int id;
    private String nom;
    

    public departmentDTO(int id, String nom) {
        this.id = id;
        this.nom = nom;
        
    }

    public departmentDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnom() {
        return nom;
    }

    public void setnom(String nom) {
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "risqueDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
