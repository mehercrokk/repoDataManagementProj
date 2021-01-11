package com.sha.serverusermanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="datasource")
public class Datasource {
    private int id;

    private String nom;
    public Datasource(int id, String nom) {
        super();
        this.id = id;
        this.nom = nom;
    }
    public Datasource(){
        super();
    }

    @Override
    public String toString() {
        return "Datasource [id=" + id + ", nom=" + nom + "]";
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
