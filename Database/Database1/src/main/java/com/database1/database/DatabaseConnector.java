package com.database1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String URL = "jdbc:mySQL://127.0.0.1:3306/ordermanagement"; // Thay thế bằng URL của bạn
    private static final String USER = "root";       // Thay thế bằng username của bạn
    private static final String PASSWORD = "";   // Thay thế bằng password của bạn

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Kết nối cơ sở dữ liệu thất bại: " + e.getMessage());
            return null;
        }
    }
}