package net.javaguides.usersregister.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.javaguides.usersregister.dao.ReservationDao;
import net.javaguides.usersregister.model.Reservation;

@WebServlet("/reservations")
public class ReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ReservationDao reservationDao;

    @Override
    public void init() {
        Connection connection = (Connection) getServletContext().getAttribute("DBConnection"); // Ensure DBConnection is set in context
        reservationDao = new ReservationDao(connection);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));
        String reservationType = request.getParameter("reservation_type");
        String reservationDate = request.getParameter("reservation_date");
        String reservationTime = request.getParameter("reservation_time");
        int guests = Integer.parseInt(request.getParameter("guests"));

        Reservation reservation = new Reservation();
        reservation.setUserId(userId);
        reservation.setReservationType(reservationType);
        reservation.setReservationDate(reservationDate);
        reservation.setReservationTime(reservationTime);
        reservation.setGuests(guests);
        reservation.setStatus("Pending");
        reservation.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        try {
            reservationDao.addReservation(reservation);
            response.sendRedirect("reservationSuccess.jsp");
        } catch (Exception e) {
            throw new ServletException("Error adding reservation", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("user_id"));

        try {
            List<Reservation> reservations = reservationDao.getReservationsByUserId(userId);
            request.setAttribute("reservations", reservations);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/viewReservations.jsp"); 
            dispatcher.forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error retrieving reservations", e);
        }
    }
}
