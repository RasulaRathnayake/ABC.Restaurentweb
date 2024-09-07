package net.javaguides.usersregister.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.javaguides.usersregister.model.Query;

public class QueryDAO {
    private Connection connection;

    public QueryDAO(Connection connection) {
        this.connection = connection;
    }

    public void addQuery(Query query) throws SQLException {
        String sql = "INSERT INTO queries (user_id, query_text) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, query.getUserId());
            stmt.setString(2, query.getQueryText());
            stmt.executeUpdate();
        }
    }

    public List<Query> getQueriesByUserId(int userId) throws SQLException {
        List<Query> queries = new ArrayList<>();
        String sql = "SELECT * FROM queries WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Query query = new Query();
                query.setQueryId(rs.getInt("query_id"));
                query.setUserId(rs.getInt("user_id"));
                query.setQueryText(rs.getString("query_text"));
                query.setResponseText(rs.getString("response_text"));
                query.setCreatedAt(rs.getTimestamp("created_at"));
                query.setRespondedAt(rs.getTimestamp("responded_at"));
                queries.add(query);
            }
        }
        return queries;
    }

    public void respondToQuery(int queryId, String responseText) throws SQLException {
        String sql = "UPDATE queries SET response_text = ?, responded_at = CURRENT_TIMESTAMP WHERE query_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, responseText);
            stmt.setInt(2, queryId);
            stmt.executeUpdate();
        }
    }
}
