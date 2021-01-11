package com.sha.serverusermanagement.service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sha.serverusermanagement.model.Constraint_details;
import org.springframework.stereotype.Service;

@Service
public class AfficherContrainteService {
    String user;
    String password;
    String nom_table;

    public List<Constraint_details> afficher_table_contraint(String user, String password, String nom_table) {
        System.out.println("-------- Oracle JDBC Connection Testing ------");
        java.sql.Connection connection = null;
        List<Constraint_details> list_table = new ArrayList<Constraint_details>();
        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            connection = DriverManager.getConnection(url, user, password);

            String sql = "SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = '" + nom_table + "'";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery(sql);

            //String sql1="SELECT COUNT (column_name) FROM all_tab_columns WHERE table_name = 'migration'";
            //ResultSet rs1 = ps.executeQuery(sql1);
            //System.out.println(rs1);
            System.out.println(rs);
            while (rs.next()) {
                Constraint_details c = new Constraint_details();
                c.setOwner(rs.getString(1));
                c.setConstraint_name(rs.getString(2));
                c.setConstrain_type(rs.getString(3));
                list_table.add(c);
                //   System.out.println(rs1.getString(1));
            }

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
        return list_table;
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

    public String getNom_table() {
        return nom_table;
    }

    public void setNom_table(String nom_table) {
        this.nom_table = nom_table;
    }
}
