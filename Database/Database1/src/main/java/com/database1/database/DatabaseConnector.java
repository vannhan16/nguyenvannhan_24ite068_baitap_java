package com.database1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String DB_URL = "jdbc:mySQL://127.0.0.1:3306/ordermanagement"; // Thay thế bằng URL của bạn
    private static final String DB_USER = "root";       // Thay thế bằng username của bạn
    private static final String DB_PASSWORD = "";   // Thay thế bằng password của bạn

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ví dụ cho MySQL, thay thế nếu bạn dùng DB khác
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Không tìm thấy Driver JDBC.", e);
        }
    }

    // Bạn có thể thêm các phương thức khác để quản lý kết nối (ví dụ: đóng kết nối)
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}