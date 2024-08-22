package com.lab4dx.l05_mvc_ex;

import java.sql.Connection;
import java.sql.DriverManager;
import oracle.jdbc.OracleDriver;

public class DBConnection {
    private static Connection conn;
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String user = "c##lab4dx";
    private static String password = "oracle";

    public static Connection getConnection() throws Exception{
        if(conn != null && !conn.isClosed()){
            return conn;
        }else {
            Class.forName( "oracle.jdbc.driver.OracleDriver");
            conn= DriverManager.getConnection(url, user, password);
            return conn;
        }
    }

    //test
    public static void main(String[] args){
        try {
            System.out.println(DBConnection.getConnection());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
