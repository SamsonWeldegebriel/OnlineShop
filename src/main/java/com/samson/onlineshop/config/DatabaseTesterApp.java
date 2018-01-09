package com.samson.onlineshop.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseTesterApp {

    public static void main(String[] args) {


        String jdbcurl = "jdbc:mysql://localhost:3306/onlineshop";
        String jdbcusername = "root";
        String jdbcpassword = "root";

        try
        {
            System.out.println("Connecting to database..");
            Connection  myConn = DriverManager.getConnection(jdbcurl, jdbcusername, jdbcpassword);
            System.out.println("Connection Successful!");

        } catch (Exception ex) {
            System.out.println("Error in connection~");
        }
    }
}
