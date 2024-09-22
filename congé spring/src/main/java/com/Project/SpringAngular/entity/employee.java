package com.Project.SpringAngular.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="employee")
public class employee {

    @Id
    @Column(name="employee_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="employee_nom",length = 50)
    private String nom;

    @Column(name="employee_prenom",length = 50)
    private String prenom;

    @Column(name="employee_email",length = 60)
    private String email;

    @Column(name="employee_password",length = 30)
    private String password;

    @Column(name="employee_role",length = 20)
    private String role;

    @ManyToOne
    private department de;


    public employee(int id, String nom, String prenom, String email, String password, department dep, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.de = dep;
        this.role = role;
    }

    public employee() {
    }

    public employee(String nom, String prenom, String email, String password, department dep, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.de = dep;
        this.role = role;
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

    public department getDe() {
        return de;
    }

    public void setDe(department de) {
        this.de = de;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "employee{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", de=" + de +
                ", role='" + role + '\'' +
                '}';
    }
}
