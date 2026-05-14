package com.vinegarbrains.controller;

import java.sql.*;

public class DatabaseManager {
    // 1. Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/movie_db";
    private static final String USER = "root"; 
    private static final String PASSWORD = "your_password_here"; // Replace with your MySQL password

    private static Connection connection = null;

    // 2. Private constructor (Prevents other classes from creating multiple managers)
    private DatabaseManager() {}

    // 3. The "Get Connection" method
    public static Connection getConnection() {
        try {
            // If connection doesn't exist or is closed, create a new one
            if (connection == null || connection.isClosed()) {
                // Register the Driver (Required for older Java versions)
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Successfully connected to MySQL!");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL Driver not found! Did you add the JAR file?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Connection failed! Check your URL, Username, or Password.");
            e.printStackTrace();
        }
        return connection;
    }

    // 4. Close connection method (Use when closing the app)
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}