package com.sha.serverusermanagement.service;
import com.sha.serverusermanagement.model.Classenomtable;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Service
public class AfficherTableService {
    String database;
    String user;
    String password;

    public  List<Classenomtable> nom_table_base(String database , String user, String password){
        java.sql.Connection connection = null;
        List<Classenomtable> list_table= new ArrayList<Classenomtable>();
        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/"+database+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" ;
            connection = DriverManager.getConnection(url, user,password);
            System.out.println("crok");

            String sql="SHOW TABLES FROM "+database;
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            System.out.println(rs);
            while(rs.next()) {
                Classenomtable c =new Classenomtable();
                c.setNom_table(rs.getString(1));
                list_table.add(c);
                //   System.out.println(rs1.getString(1));
            }

        } catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                connection.close();
                ps.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        return list_table;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
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
