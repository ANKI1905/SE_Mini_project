<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>MealOn Add Student</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/css/homepage.css">

</head>
<body>
<%	//This prevents browser from saving cache
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP1.1
	response.setHeader("Pragma", "n-cache"); //HTTP 1.0
	response.setHeader("Expires", "0"); //Proxies

	if(session.getAttribute("log") == null) {
		response.sendRedirect("adminLogin.jsp");
	}
%>
	<br><br>
	<h1>MealOn</h1>
	<h2>Add Student</h2>
	<div class="align_center">
		<form action="student/signin" method="post">
			<input class ="form_data" required="required" type="number" name="mis"pattern="[0-9]{9}" placeholder="MIS"/><br></br>
			<input class ="form_data" required="required" type="text" name="name" placeholder="Name" /><br></br>
            <input class ="form_data" required="required" type="text" name="room_no" placeholder="Room No" /><br></br>
            <input class ="form_data" required="required" type="number" name="year_of_study" placeholder="Year Of Study"/><br></br>
			<input class ="form_data" required="required" type="tel" name="contact"  placeholder="Phone No"/><br></br>
			<input class ="form_data" required="required" type="email" name="email" placeholder="Email"/><br></br>
			<input class ="form_data" required="required" type="password" name="password" placeholder="Password"/><br></br>
			<input class="green_btn medium_btn" type="submit" value="Login" />
		</form>
		<br><br><br>
	</div>
</body>
</html>