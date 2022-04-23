<html>

<head>
<title>Home</title>
<style>
body {
	background-image: url("bggcimg.jpeg");
	background-color: hsla(89, 43%, 51%, 0.3);
}

.vertical-menu {
	width: 200px;
}

.vertical-menu a {
	background-color: #eee;
	color: black;
	display: block;
	padding: 12px;
	text-decoration: none;
}

.vertical-menu a:hover {
	background-color: #ccc;
}

.vertical-menu a.active {
	background-color: #4CAF50;
	color: white;
}

/* navbar css */
.navbar {
	overflow: hidden;
	background-color: #333;
}

.navbar a {
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 30px;
	text-decoration: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: green;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

/* Top Navigation Menu */
.topnav {
	overflow: hidden;
	background-color: #e9e9e9;
}

.topnav a {
	float: left;
	display: block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #2196F3;
	color: white;
}

.topnav input[type=text] {
	float: right;
	padding: 6px;
	margin-top: 8px;
	margin-right: 16px;
	border: none;
	font-size: 17px;
}

@media screen and (max-width: 600px) {
	.topnav a, .topnav input[type=text] {
		float: none;
		display: block;
		text-align: left;
		width: 100%;
		margin: 0;
		padding: 14px;
	}
	.topnav input[type=text] {
		border: 1px solid #ccc;
	}
}

/* Navigation bottom Menu */
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.navbarbottom {
	overflow: hidden;
	background-color: #333;
	position: fixed;
	bottom: 0;
	width: 100%;
}

.navbarbottom a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.navbarbottom a:hover {
	background: #f1f1f1;
	color: black;
}

.navbarbottom a.active {
	background-color: #4CAF50;
	color: white;
}
</style>
</head>

<body>
	<!-- <table border="5" style="background:#FFFFFF" align="center" > -->
	<!-- <tr> -->
	<!-- <th> -->
	<!-- 	<a href="/usersList">User List</a> -->
	<!-- </th> -->

	<!-- <th>    -->
	<!--     <a href="/userSignUp">User SignUp !!!! </a> -->
	<!-- </th> -->
	<!-- <th> -->
	<!-- 	<a href="/searchUser">Search User</a> -->
	<!-- </th> -->

	<!-- </tr> -->
	<!-- </table> -->

	<!-- <div class="topnav"> -->
	<!--   <a class="active" href="#home">Home</a> -->
	<!--   <a href="#about">About</a> -->
	<!--   <a href="#contact">Contact</a> -->
	<!--   <input type="text" placeholder="Search.."> -->
	<!-- </div> -->

	<!-- <h1 color="white">Select Option</h1> -->

	<!-- <div class="vertical-menu" draggable="true"> -->
	<!-- <!--   <a href="/home" class="active">Home</a> -->
	-->
	<!--   <a href="/usersList">User List</a> -->
	<!--   <a href="/userSignUp">User SignUp</a> -->
	<!--   <a href="/searchUser">Search User</a> -->
	<!-- </div> -->

	<div class="navbar">
		<a href="#home">Home</a>
		<!--    <a href="#news">News</a> -->
		<a href="https://javathebesty.blogspot.com/">My Blog</a>
		<div class="dropdown">
			<button class="dropbtn">
				Select Menu <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="/usersList">User List</a> <a href="/userSignUp">User
					SignUp</a> <a href="/searchUser">Search User</a>
			</div>
		</div>
	</div>

	<div class="navbarbottom">
		<a href="#home" class="active">Home</a> <a href="#news">News</a> <a
			href="#contact">Contact</a>
	</div>

</body>

</html>