<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
    <title>Admin - Respond to Queries</title>
</head>
<body>
    <h2>Respond to Queries</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Query ID</th>
                <th>Query</th>
                <th>Submitted On</th>
                <th>Respond</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="query" items="${queriesList}">
                <tr>
                    <td>${query.queryId}</td>
                    <td>${query.queryText}</td>
                    <td>${query.submittedOn}</td>
                    <td>
                        <form action="<%= request.getContextPath() %>/respondToQuery" method="post">
                            <input type="hidden" name="queryId" value="${query.queryId}" />
                            <textarea name="responseText" required></textarea>
                            <button type="submit">Respond</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
