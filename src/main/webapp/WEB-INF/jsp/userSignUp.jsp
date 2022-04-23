<html>

<head>

<style>
body  {
  background-image: url("signup.jpg");
  background-color: #cccccc;
}
</style>
<title>First Web Application</title>

<script type="text/javascript">
function checkForm(form)
{
	 
	var t =document.getElementById("UserId").value;
	var e =document.getElementById("UserName").value;
	var f =document.getElementById("password").value;
	var g =document.getElementById("EmailId").value;
	  
	if(t.length ==0 ) 
	{
			alert("Error: UserId value cannot be NULL!");
	    return false;
	  }
	
	  
	if(e.length ==0 ) 
	{
			alert("Error: UserName value cannot be NULL!");
		return false;
	}
	
	if(f.length ==0 ) 
	{
			alert("Error: Password value cannot be NULL!");
	    return false;
	  }
	
	  
	if(g.length ==0 ) 
	{
			alert("Error: Email value cannot be NULL!");
		return false;
	}
}
</script>
</head>
<center>
<h3 >User SignUp Form</h3>
</center>

<div align="left">
<a href="/home">Back</div></a>
<body>
    <font color="red">${errorMessage}</font>
    
    <div align="center">
    <form method="post" onsubmit="return checkForm(this)">
    	UserId   : &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="text" id="UserId" name="UserId" /><br><br>
        UserName : &nbsp <input type="text" id="UserName" name="UserName" /><br><br>
        Password : &nbsp&nbsp&nbsp<input type="password" id="password" name="password" /><br><br>
        EmailId  : &nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" id="EmailId" name="EmailId" /> 
        <br>
        <br>
        &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
        &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
        &nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp
        <input type="submit" />
        </div>
        
    </form>
</body>

</html>