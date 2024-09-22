package com.Project.SpringAngular.DTO;

import com.Project.SpringAngular.entity.department;

public class employeesaveDTO {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private department dep;
    private String role;

    public employeesaveDTO(int id, String nom, String prenom, String email, String password, department id_dep, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.dep = id_dep;
        this.role = role;
    }

    public employeesaveDTO() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public department getDep() {
        return dep;
    }

    public void setDep(department dep) {
        this.dep = dep;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "employeesaveDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dep=" + dep +
                ", role='" + role + '\'' +
                '}';
    }
}