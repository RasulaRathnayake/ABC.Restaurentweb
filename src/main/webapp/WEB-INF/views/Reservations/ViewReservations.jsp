<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Reservations</title>
</head>
<body>
    <h2>Your Reservations</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Reservation ID</th>
                <th>Type</th>
                <th>Date</th>
                <th>Time</th>
                <th>Guests</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="reservation" items="${reservations}">
                <tr>
                    <td>${reservation.reservationId}</td>
                    <td>${reservation.reservationType}</td>
                    <td>${reservation.reservationDate}</td>
                    <td>${reservation.reservationTime}</td>
                    <td>${reservation.guests}</td>
                    <td>${reservation.status}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="<%= request.getContextPath() %>/index.jsp">Go to Home</a>
</body>
</html>
