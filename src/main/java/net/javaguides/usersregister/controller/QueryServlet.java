package net.javaguides.usersregister.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.usersregister.dao.QueryDAO;
import net.javaguides.usersregister.model.Query;
import net.javaguides.usersregister.util.DBUtils;

@WebServlet("/submitQuery")
public class QueryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String queryText = req.getParameter("queryText");

        try (Connection conn = DBUtils.getConnection()) {
            QueryDAO queryDAO = new QueryDAO(conn);
            Query query = new Query();
            query.setUserId(userId);
            query.setQueryText(queryText);
            queryDAO.addQuery(query);

            resp.sendRedirect("queries.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
