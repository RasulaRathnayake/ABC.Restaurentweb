package net.javaguides.usersregister.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/abc_restaurant"; // Replace with your database URL
    private static final String JDBC_USER = "root"; // Replace with your DB username
    private static final String JDBC_PASSWORD = "rasula13675"; // Replace with your DB password

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        return connection;
    }
}
