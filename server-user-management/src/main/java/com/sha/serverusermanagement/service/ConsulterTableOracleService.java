package com.sha.serverusermanagement.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.sha.serverusermanagement.model.Nom_columne;
import org.springframework.stereotype.Service;

@Service
public class ConsulterTableOracleService {
    private String user;
    private String password;
    private String table;

    public List<Nom_columne> doconsulter(String user, String password, String table) {
        System.out.println("-------- Oracle JDBC Connection Testing ------");
        java.sql.Connection conn = null;
        List<Nom_columne> list_table = new ArrayList<Nom_columne>();
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", user, password);
            System.out.println("conn ok");
            String sql = "SELECT column_name, data_type, data_length FROM user_tab_columns WHERE table_name = '" + table + "'";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
            while (rs.next()) {
                Nom_columne c = new Nom_columne();
                Map<String, Object> row = new HashMap<String, Object>(columns);
                for (int i = 1; i <= columns; ++i) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }
                rows.add(row);
                for (int i = 0; i < rows.size(); i++) {
                    System.out.println(rows.get(i));
                    c.setColumne(rows.get(i));
                    row.get(i);
                    list_table.add(c);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
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

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
