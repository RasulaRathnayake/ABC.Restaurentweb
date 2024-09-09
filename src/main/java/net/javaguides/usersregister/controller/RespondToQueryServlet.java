package net.javaguides.usersregister.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.usersregister.dao.QueryDAO;

@WebServlet("/respondToQuery")
public class RespondToQueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant_db", "username", "password");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int queryId = Integer.parseInt(req.getParameter("queryId"));
        String responseText = req.getParameter("responseText");

        try (Connection conn = getConnection()) {
            QueryDAO queryDAO = new QueryDAO(conn);
            queryDAO.respondToQuery(queryId, responseText);

            resp.sendRedirect("/WEB-INF/views/admin/adminQueries.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
