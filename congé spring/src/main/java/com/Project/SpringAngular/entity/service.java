package com.Project.SpringAngular.entity;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="service")
public class service {
    @Id
    @Column(name="service_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="service_nom",length = 50)
    private String nom;

    /*@OneToMany
    private List<user> emps;*/

    public service(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public service() {
    }

    public service(String nom) {
        this.nom = nom;
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
        return "service{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
