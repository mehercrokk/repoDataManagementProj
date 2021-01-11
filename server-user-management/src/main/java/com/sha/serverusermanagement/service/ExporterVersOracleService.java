package com.sha.serverusermanagement.service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ExporterVersOracleService {
    private static String JDBC_CONNECTION_URL =
            "jdbc:oracle:thin:@localhost:1521:xe";


    public boolean load_csv_oracle() {


        try {

            CSVLoader loader = new CSVLoader(getCon());
            loader.loadCSV("C:/Users/crok0/Desktop/proxy/springboot-angular/countrylanguage.csv.csv", "countrylanguage");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    private static Connection getCon() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(JDBC_CONNECTION_URL, "meher", "crok");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
