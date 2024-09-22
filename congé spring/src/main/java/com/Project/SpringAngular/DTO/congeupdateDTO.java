package com.Project.SpringAngular.DTO;

import com.Project.SpringAngular.entity.employee;

import java.time.LocalDate;

public class congeupdateDTO {

    private int id;
    private String nature;
    private LocalDate date_d;
    private LocalDate date_f;
    private LocalDate date_rep;
    private employee emp;
    private String etat; // New field

    public congeupdateDTO(int id,  String etat) {
        this.id = id;

        this.etat = etat;
    }

    public congeupdateDTO() {
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "congeupdateDTO{" +
                "id=" + id +
                ", nature='" + nature + '\'' +
                ", date_d=" + date_d +
                ", date_f=" + date_f +
                ", date_rep='" + date_rep + '\'' +
                ", emp=" + emp +
                ", etat='" + etat + '\'' +
                '}';
    }
}