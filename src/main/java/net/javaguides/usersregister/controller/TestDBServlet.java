package net.javaguides.usersregister.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.usersregister.util.DBUtils;

@WebServlet("/testDB")
public class TestDBServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conn = DBUtils.getConnection()) {
            response.getWriter().println("Database connected successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("Database connection failed: " + e.getMessage());
        }
    }
}
