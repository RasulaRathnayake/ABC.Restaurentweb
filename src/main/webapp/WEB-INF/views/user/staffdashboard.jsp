<!DOCTYPE html>
<html>
<head>
    <title>Staff Dashboard</title>
</head>
<body>
    <h1>Welcome to the Staff Dashboard</h1>
    <p>Here you can manage reservations, respond to queries, and perform other tasks.</p>
    <a href="<%= request.getContextPath() %>/viewReservations.jsp">View Reservations</a><br><br>
    <a href="<%= request.getContextPath() %>/respondToQueries.jsp">Respond to Queries</a><br><br>
    <a href="<%= request.getContextPath() %>/logout">Logout</a>
</body>
</html>
