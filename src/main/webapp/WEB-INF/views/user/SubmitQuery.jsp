<!DOCTYPE html>
<html>
<head>
    <title>Submit a Query</title>
</head>
<body>
    <h2>Submit Your Query</h2>
    <form action="<%= request.getContextPath() %>/submitQuery" method="post">
        <label for="queryText">Query:</label><br>
        <textarea id="queryText" name="queryText" required></textarea><br><br>
        <input type="submit" value="Submit Query">
    </form>
    <p><a href="<%= request.getContextPath() %>/viewQueries.jsp">View Submitted Queries</a></p>
</body>
</html>
