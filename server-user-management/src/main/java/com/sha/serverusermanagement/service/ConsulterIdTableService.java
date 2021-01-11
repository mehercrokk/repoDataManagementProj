package com.sha.serverusermanagement.service;
import com.sha.serverusermanagement.model.ID_details;
import org.springframework.stereotype.Service;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ConsulterIdTableService {
    String user;
    String password;
    String table;
    public List<ID_details> doconsulter_ID(String user, String password, String table){
        System.out.println("-------- Oracle JDBC Connection Testing ------");
        java.sql.Connection connection = null;
        List<ID_details> list_table= new ArrayList<ID_details>();
        PreparedStatement ps = null;

        ResultSet rs = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url="jdbc:oracle:thin:@localhost:1521:xe";
            connection = DriverManager.getConnection(url,user,password);

            String sql="SELECT cols.table_name, cols.column_name, cols.position, cons.status, cons.owner FROM all_constraints cons, all_cons_columns cols WHERE cols.table_name = '"+table+"' AND cons.constraint_type = 'P' AND cons.constraint_name = cols.constraint_name AND cons.owner = cols.owner ORDER BY cols.table_name, cols.position";
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery(sql);

            //String sql1="SELECT COUNT (column_name) FROM all_tab_columns WHERE table_name = 'migration'";
            //ResultSet rs1 = ps.executeQuery(sql1);
            //System.out.println(rs1);
            System.out.println(rs);
            while(rs.next()) {
                ID_details c =new ID_details();
                c.setNom_table(rs.getString(1));
                c.setCulomn_name(rs.getString(2));
                c.setPosition(rs.getInt(3));
                c.setStatus(rs.getString(4));
                c.setOwner(rs.getString(5));
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
    public String getTable() {
        return table;
    }
    public void setTable(String table) {
        this.table = table;
    }
}
