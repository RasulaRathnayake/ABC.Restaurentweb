<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Queries</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <h2>Submitted Queries</h2>

    <table border="1">
        <thead>
            <tr>
                <th>User ID</th>
                <th>Query</th>
                <th>Submitted On</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="query" items="${queriesList}">
                <tr>
                    <td>${query.userId}</td>
                    <td>${query.queryText}</td>
                    <td>${query.submittedOn}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="submitQuery.jsp">Submit a New Query</a>
</body>
</html>
