package com.sha.serverusermanagement.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;
import java.util.List;

import liquibase.util.StringUtils;
import liquibase.util.csv.opencsv.CSVReader;
//import org.apache.commons.lang.StringUtils;

//import com.microsoft.schemas.office.visio.x2012.main.CellType;

//import au.com.bytecode.opencsv.CSVParser;
//import au.com.bytecode.opencsv.CSVReader;

public class CSVLoader {
    private static final
    String SQL_INSERT = "INSERT INTO ${table}(${keys}) VALUES(${values})";
    private static final String TABLE_REGEX = "\\$\\{table\\}";
    private static final String KEYS_REGEX = "\\$\\{keys\\}";
    private static final String VALUES_REGEX = "\\$\\{values\\}";
    //private static final String TYPE_REGEX = "\\$\\{types\\}";
    private static final String TYPE_REGEX = "varchar2(50)";
    String SQL_CREATE = "CREATE TABLE ${table} (${keys} varchar2(50))";
    private Connection connection;
    private char seprator;

    /**
     * Public constructor to build CSVLoader object with
     * Connection details. The connection is closed on success
     * or failure.
     *
     * @param connection
     */
    public CSVLoader(Connection connection) {
        this.connection = connection;
        //Set default separator
        this.seprator = ',';
    }
    public void loadCSV(String csvFile, String tableName
    ) throws Exception {

        CSVReader csvReader = null;
        if (null == this.connection) {
            throw new Exception("Not a valid connection.");
        }
        try {

            csvReader = new CSVReader(new FileReader(csvFile), this.seprator);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error occured while executing file. "
                    + e.getMessage());
        }

        String[] headerRow = csvReader.readNext();

        if (null == headerRow) {
            throw new FileNotFoundException(
                    "No columns defined in given CSV file." +
                            "Please check the CSV file format.");
        }

        String questionmarks = StringUtils.repeat("?,", headerRow.length);
        questionmarks = (String) questionmarks.subSequence(0, questionmarks
                .length() - 1);

        String query = SQL_INSERT.replaceFirst(TABLE_REGEX, tableName);
        query = query
                .replaceFirst(KEYS_REGEX, StringUtils.join(headerRow, ","));
        query = query.replaceFirst(VALUES_REGEX, questionmarks);

        String query2 = SQL_CREATE.replaceFirst(TABLE_REGEX, tableName);

        query2 = query2
                .replaceFirst(KEYS_REGEX, StringUtils.join(headerRow, " varchar2(50),"));
        query2 = query2.replaceFirst(TYPE_REGEX, "varchar2(50)");


        System.out.println("Query: " + query);
        System.out.println("Query: " + query2);
        String[] nextLine;
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        try {
            con = this.connection;
            con.setAutoCommit(false);
            ps = con.prepareStatement(query);
            ps2 = con.prepareStatement(query2);


            final int batchSize = 1000;
            int count = 0;
            Date date = null;
            while ((nextLine = csvReader.readNext()) != null) {

                if (null != nextLine) {
                    int index = 1;
                    for (String string : nextLine) {
                        date = DateUtil.convertToDate(string);
                        if (null != date) {
                            ps.setDate(index++, new java.sql.Date(date
                                    .getTime()));
                        } else {
                            ps.setString(index++, string);
                        }
                    }

                    ps.addBatch();
                }
                if (++count % batchSize == 0) {
                    ps.executeBatch();
                }
            }
            ps2.executeQuery(query2);
            ps.executeBatch(); // insert remaining records
            con.commit();
        } catch (Exception e) {
            con.rollback();
            e.printStackTrace();
            throw new Exception(
                    "Error occured while loading data from file to database."
                            + e.getMessage());
        } finally {
            if (null != ps)
                ps.close();
            if (null != con)
                con.close();

            csvReader.close();
        }
    }

    public char getSeprator() {
        return seprator;
    }

    public void setSeprator(char seprator) {
        this.seprator = seprator;
    }
}
