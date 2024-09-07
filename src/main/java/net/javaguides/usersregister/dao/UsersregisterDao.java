package net.javaguides.usersregister.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import net.javaguides.usersregister.model.Usersregister;

public class UsersregisterDao {

    // Method to insert user into the database
    public void usersregister(Usersregister user) {
        String sql = "INSERT INTO users (user_id, name, email, password, role) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUser_id());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Method to get a database connection
    private Connection getConnection() throws SQLException {
        // Replace with your actual database connection details
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");
    }
}
