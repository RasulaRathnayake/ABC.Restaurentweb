package net.javaguides.usersregister.dao; // Correct package

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import net.javaguides.usersregister.model.Payment;

public class PaymentDAO {
    private Connection connection;

    public PaymentDAO(Connection connection) {
        this.connection = connection;
    }

    public void addPayment(Payment payment) throws SQLException {
        String sql = "INSERT INTO payment (user_id, reservation_id, amount, payment_date, payment_method) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, payment.getUserId());
            statement.setInt(2, payment.getReservationId());
            statement.setDouble(3, payment.getAmount());
            statement.setTimestamp(4, new Timestamp(payment.getPaymentDate().getTime())); // Use Timestamp for payment_date
            statement.setString(5, payment.getPaymentMethod());
            statement.executeUpdate();
        }
    }

    public List<Payment> getPaymentsByUserId(int userId) throws SQLException {
        List<Payment> payments = new ArrayList<>();
        String sql = "SELECT * FROM payment WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setPaymentId(resultSet.getInt("payment_id"));
                payment.setUserId(resultSet.getInt("user_id"));
                payment.setReservationId(resultSet.getInt("reservation_id"));
                payment.setAmount(resultSet.getDouble("amount"));
                payment.setPaymentDate(resultSet.getTimestamp("payment_date")); // Retrieve as Timestamp
                payment.setPaymentMethod(resultSet.getString("payment_method"));
                payments.add(payment);
            }
        }
        return payments;
    }

    public Payment getPaymentById(int paymentId) throws SQLException {
        Payment payment = null;
        String sql = "SELECT * FROM payment WHERE payment_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, paymentId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                payment = new Payment();
                payment.setPaymentId(resultSet.getInt("payment_id"));
                payment.setUserId(resultSet.getInt("user_id"));
                payment.setReservationId(resultSet.getInt("reservation_id"));
                payment.setAmount(resultSet.getDouble("amount"));
                payment.setPaymentDate(resultSet.getTimestamp("payment_date")); // Retrieve as Timestamp
                payment.setPaymentMethod(resultSet.getString("payment_method"));
            }
        }
        return payment;
    }
}
