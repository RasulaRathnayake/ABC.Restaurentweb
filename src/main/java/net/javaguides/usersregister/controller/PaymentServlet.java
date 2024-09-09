package net.javaguides.usersregister.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.usersregister.dao.PaymentDAO;
import net.javaguides.usersregister.model.Payment;
import net.javaguides.usersregister.util.DBUtils;

@WebServlet("/processPayment")
public class PaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("userId"));
        int reservationId = Integer.parseInt(request.getParameter("reservationId"));
        double amount = Double.parseDouble(request.getParameter("amount"));
        String paymentMethod = request.getParameter("paymentMethod");

        Payment payment = new Payment();
        payment.setUserId(userId);
        payment.setReservationId(reservationId);
        payment.setAmount(amount);
        payment.setPaymentMethod(paymentMethod);

        
        Date currentDate = new Date();
        payment.setPaymentDate(new Timestamp(currentDate.getTime())); 
        try (Connection conn = DBUtils.getConnection()) {
            PaymentDAO paymentDAO = new PaymentDAO(conn);
            paymentDAO.addPayment(payment);
            response.sendRedirect("paymentSuccess.jsp");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
