package com.Project.SpringAngular.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name="conge")
public class conge {

    @Id
    @Column(name = "conge_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "conge_nature", length = 50)
    private String nature;

    @Column(name = "conge_date_d", length = 60)
    private LocalDate date_d;

    @Column(name = "conge_date_f", length = 15)
    private LocalDate date_f;

    @Column(name = "conge_date_rep", length = 15)
    private LocalDate date_rep;

    @ManyToOne // Many conge records can be associated with one employee
    private employee emp; // New field

    public conge(int id, String nature, LocalDate date_d, LocalDate date_f, LocalDate date_rep, employee emp) {
        this.id = id;
        this.nature = nature;
        this.date_d = date_d;
        this.date_f = date_f;
        this.date_rep = date_rep;
        this.emp = emp;
    }

    public conge() {
    }

    public conge(String nature, LocalDate date_d, LocalDate date_f, LocalDate date_rep, employee emp) {

        this.nature = nature;
        this.date_d = date_d;
        this.date_f = date_f;
        this.date_rep = date_rep;
        this.emp = emp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public LocalDate getDate_d() {
        return date_d;
    }

    public void setDate_d(LocalDate date_d) {
        this.date_d = date_d;
    }

    public LocalDate getDate_f() {
        return date_f;
    }

    public void setDate_f(LocalDate date_f) {
        this.date_f = date_f;
    }

    public LocalDate getDate_rep() {
        return date_rep;
    }

    public void setDate_rep(LocalDate date_rep) {
        this.date_rep = date_rep;
    }

    public employee getEmp() {
        return emp;
    }

    public void setEmp(employee emp) {
        this.emp = emp;
    }

    @Override
    public String toString() {
        return "conge{" +
                "id=" + id +
                ", nature='" + nature + '\'' +
                ", date_d=" + date_d +
                ", date_f=" + date_f +
                ", date_rep='" + date_rep + '\'' +
                ", emp=" + emp +
                '}';
    }
}