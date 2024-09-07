<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>Welcome to ABC Restaurant</h1>
    <a href="<%= request.getContextPath() %>/user/register.jsp">Register</a>
    <a href="<%= request.getContextPath() %>/user/Login.jsp">Login</a>
</body>
</html>
