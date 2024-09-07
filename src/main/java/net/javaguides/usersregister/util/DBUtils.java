package net.javaguides.usersregister.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.javaguides.usersregister.util.DBUtils;


public class DBUtils {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String JDBC_USER = "username";
    private static final String JDBC_PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Ensure the JDBC driver is available
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found", e);
        }
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}
