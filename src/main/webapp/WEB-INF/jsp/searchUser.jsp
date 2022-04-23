<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body  {
  background-image: url("search.jpg");
  background-color: #cccccc;
}
</style>
<meta charset="ISO-8859-1">
<title>Search User</title>

<script type="text/javascript">
function checkForm(form)
{
	 
	var t =document.getElementById("userName").value;
	  
	if(t.length ==0 ) 
	{
			alert("Error: userName value cannot be NULL!");
	    return false;
	}
}
</script>

</head>

<center>
<h3 >User Search Form</h3>
</center>

<div align="left" color="black">
<a href="/home">Back</div></a>

<body>

<font color="red">${errorMessage}</font>
    
    <div align="center">
    <form method="post" onsubmit="return checkForm(this)">
    	UserName : &nbsp <input type="text" id="userName" name="userName" /><br><br>
         &nbsp  &nbsp  &nbsp  &nbsp  &nbsp  &nbsp
         	<button type="submit">Search</button>
        </div>
        
    </form>
<br>

<c:if test="${!empty noData}" color="red">
<center>
	<font color="red" >${noData}</font>
</center>
</c:if>

<br>
    
<c:if test="${!empty user}">

<table border="1" style="background:#FFFFFF" align="center"> 
<tr style="background-color:#587DC6;">
<td><b>User_Id</b></td>
<td><b>UserName</b></td>
<td><b>Email</b></td>
</tr>
<c:forEach items="${user}" var="user">
<tr>
<td><b>${user.userId}</b></td>
<td><b>${user.username}</b></td>
<td><b>${user.emailId}</b></td>
</tr>
</c:forEach>

</table>

</c:if>

</body>
</html>