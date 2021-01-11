package com.sha.serverusermanagement.service;

import org.springframework.stereotype.Service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@Service
public class JoindreTableService {
    String user;
    String password;
    String nom_table;
    String nom_table1;
    String nom_table2;
    String colonne;
    String column1;
    String column2;
    String nom_constraint;
    String nom_de_cle_prem;


    public Boolean joindre_table(String user, String password, String nom_table1,String nom_table2, String column1,  String column2, String nom_constraint) {
        System.out.println("-------- Oracle JDBC Connection Testing ------");
        java.sql.Connection connection = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            connection = DriverManager.getConnection(url, user, password);

            String sql = "ALTER TABLE " + nom_table1 + " ADD CONSTRAINT " + nom_constraint + " FOREIGN KEY (" + column1 + ") REFERENCES " + nom_table2 + " (" + column2 + ")";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery(sql);

            //String sql1="SELECT COUNT (column_name) FROM all_tab_columns WHERE table_name = 'migration'";
            //ResultSet rs1 = ps.executeQuery(sql1);
            //System.out.println(rs1);
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    public boolean Creer_ID(String user, String password, String nom_table, String nom_de_cle_prem, String colonne) {
        System.out.println("-------- Oracle JDBC Connection Testing ------");
        java.sql.Connection connection = null;

        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            connection = DriverManager.getConnection(url, user, password);

            String sql = "ALTER TABLE " + nom_table + " ADD CONSTRAINT " + nom_de_cle_prem + " PRIMARY KEY (" + colonne + ");";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery(sql);

            //String sql1="SELECT COUNT (column_name) FROM all_tab_columns WHERE table_name = 'migration'";
            //ResultSet rs1 = ps.executeQuery(sql1);
            //System.out.println(rs1);
            System.out.println(rs);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom_table1() {
        return nom_table1;
    }

    public void setNom_table1(String nom_table1) {
        this.nom_table1 = nom_table1;
    }

    public String getNom_table2() {
        return nom_table2;
    }

    public void setNom_table2(String nom_table2) {
        this.nom_table2 = nom_table2;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getNom_constraint() {
        return nom_constraint;
    }

    public void setNom_constraint(String nom_constraint) {
        this.nom_constraint = nom_constraint;
    }

    public String getNom_de_cle_prem() {
        return nom_de_cle_prem;
    }

    public void setNom_de_cle_prem(String nom_de_cle_prem) {
        this.nom_de_cle_prem = nom_de_cle_prem;
    }


    public String getNom_table() {
        return nom_table;
    }


    public void setNom_table(String nom_table) {
        this.nom_table = nom_table;
    }


    public String getColonne() {
        return colonne;
    }


    public void setColonne(String colonne) {
        this.colonne = colonne;
    }

}
