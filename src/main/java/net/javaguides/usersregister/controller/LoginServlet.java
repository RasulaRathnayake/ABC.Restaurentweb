package net.javaguides.usersregister.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.javaguides.usersregister.util.DBUtils;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
       

        try (Connection connection = DBUtils.getConnection()) {
            String sql = "SELECT * FROM users WHERE email = ? AND password = ?"; 
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, email);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", resultSet.getString("name"));
                    session.setAttribute("role", resultSet.getString("role"));

                    // Redirect based on role
                    if ("admin".equals(resultSet.getString("role"))) {
                        response.sendRedirect("admindashboard.jsp");
                    } else if ("staff".equals(resultSet.getString("role"))) {
                        response.sendRedirect("staffdashboard.jsp");
                    } else {
                        response.sendRedirect("customerdashboard.jsp");
                    }
                } else {
                    request.setAttribute("errorMessage", "Invalid email or password");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}
