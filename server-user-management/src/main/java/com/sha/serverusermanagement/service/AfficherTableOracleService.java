package com.sha.serverusermanagement.service;
import com.sha.serverusermanagement.model.Nom_table_oracle;
import org.springframework.stereotype.Service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Service
public class AfficherTableOracleService {
    String user;
    String password;

    public List<Nom_table_oracle> connecter_afficher_table_oracle(String user, String password) {
        System.out.println("-------- Oracle JDBC Connection Testing ------");
        java.sql.Connection connection = null;
        List<Nom_table_oracle> list_table = new ArrayList<Nom_table_oracle>();
        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            connection = DriverManager.getConnection(url, user, password);

            String sql = "SELECT table_name FROM user_tables";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery(sql);

            //String sql1="SELECT COUNT (column_name) FROM all_tab_columns WHERE table_name = 'migration'";
            //ResultSet rs1 = ps.executeQuery(sql1);
            //System.out.println(rs1);
            System.out.println(rs);
            while (rs.next()) {
                Nom_table_oracle c = new Nom_table_oracle();
                c.setNom_table(rs.getString(1));
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
}
