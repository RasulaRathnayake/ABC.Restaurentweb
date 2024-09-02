<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Register</title>
</head>
<body>
<div align="center">
  <h1>Customers Register Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>User ID</td>
     <td><input type="text" name="user_id" /></td>
    </tr>
    <tr>
     <td>Name</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="password" /></td>
    </tr>
    <tr>
     <td>Role</td>
     <td><input type="text" name="role" /></td>
    </tr>
    <tr>  
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>

</body>
</html>