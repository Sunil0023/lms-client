<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body  {
  background-image: url("users.jpg");
  background-color: #cccccc;
}
</style>
<meta charset="ISO-8859-1">	
<title>Users List</title>
</head>
<a href="home">Home</a>
<body>

<h3 align="center">User List:</h3>
<c:if test="${!empty users}">

<table border="1" style="background:#FFFFFF" align="center"> 
<tr style="background-color:#587DC6;">
<td><b>User_Id</b></td>
<td><b>UserName</b></td>
<td><b>Email</b></td>
</tr>
<c:forEach items="${users}" var="user">
<tr>
<td><b>${user.userId}</b></td>
<td><b>${user.username}</b></td>
<td><b>${user.emailId}</b></td>
</tr>
</c:forEach>

</table>

</c:if>
	<BR />
<br>
<table>

</table>	
<a href="downloadUsers" align="right">Download All Users File</a>

<c:if test="${!empty downloadlocation}">
File downloaded at: ${downloadlocation}
</c:if>
</body>
</html>