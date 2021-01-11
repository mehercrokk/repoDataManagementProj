package com.sha.serverusermanagement.model;

public class ID_details {
    private String nom_table;
    private String culomn_name;
    private int position;
    private String status;
    private String owner;

    public String getNom_table() {
        return nom_table;
    }

    public void setNom_table(String nom_table) {
        this.nom_table = nom_table;
    }

    public String getCulomn_name() {
        return culomn_name;
    }

    public void setCulomn_name(String culomn_name) {
        this.culomn_name = culomn_name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
