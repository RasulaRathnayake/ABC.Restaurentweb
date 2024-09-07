package net.javaguides.usersregister.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import net.javaguides.usersregister.model.Reservation;

public class ReservationDao {
    private Connection connection;

    public ReservationDao(Connection connection) {
        this.connection = connection;
    }

    public void addReservation(Reservation reservation) throws SQLException {
        String query = "INSERT INTO reservations (user_id, reservation_type, reservation_date, reservation_time, guests, status, created_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, reservation.getUserId());
            stmt.setString(2, reservation.getReservationType());
            stmt.setString(3, reservation.getReservationDate());
            stmt.setString(4, reservation.getReservationTime());
            stmt.setInt(5, reservation.getGuests());
            stmt.setString(6, reservation.getStatus());
            stmt.setTimestamp(7, reservation.getCreatedAt() != null ? reservation.getCreatedAt() : null);

            stmt.executeUpdate();
        }
    }

    public List<Reservation> getReservationsByUserId(int userId) throws SQLException {
        List<Reservation> reservations = new ArrayList<>();
        String query = "SELECT * FROM reservations WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reservation reservation = new Reservation();
                reservation.setReservationId(rs.getInt("reservation_id"));
                reservation.setUserId(rs.getInt("user_id"));
                reservation.setReservationType(rs.getString("reservation_type"));
                reservation.setReservationDate(rs.getString("reservation_date"));
                reservation.setReservationTime(rs.getString("reservation_time"));
                reservation.setGuests(rs.getInt("guests"));
                reservation.setStatus(rs.getString("status"));
                reservation.setCreatedAt(rs.getTimestamp("created_at"));

                reservations.add(reservation);
            }
        }
        return reservations;
    }

    public void updateReservationStatus(int reservationId, String status) throws SQLException {
        String query = "UPDATE reservations SET status = ? WHERE reservation_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setInt(2, reservationId);
            stmt.executeUpdate();
        }
    }
}
