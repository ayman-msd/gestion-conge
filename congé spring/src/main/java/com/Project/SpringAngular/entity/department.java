package com.Project.SpringAngular.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="department")
public class department {

    @Id
    @Column(name="department_id",length = 100)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="department_nom",length = 100)
    private String nom;

    @OneToMany
    private List<employee> emp;


    public department(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public department() {
    }

    public department(String nom) {
        this.nom = nom;
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
        return "departmentDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
