<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>MealOn Mess</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/css/homepage.css">

</head>
<body>
<%	//This prevents browser from saving cache
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP1.1
	response.setHeader("Pragma", "n-cache"); //HTTP 1.0
	response.setHeader("Expires", "0"); //Proxies

	if(session.getAttribute("log") == null) {
		response.sendRedirect("studentLogin.jsp");
	}
%>
	<br><br>
	<h1>Hello ${name} Welcome!</h1>
	<h3>${status}</h3>
	<hr>
	<form action="/students/menuToday">
		<input class = "green_btn medium_btn" type="submit" title="View today's menu" value="Menu Timetable" />
	</form>
	<br>
	<form action="/students/review">
		<input class = "green_btn medium_btn" type="submit" title="Give feedback to improve your mess" value="Review/Ratings" />
	</form>
	<br>
	<form action="/students/viewProfile">
		<input class = "green_btn medium_btn" type="submit" title="View and Edit your profile" value="My Profile" />
	</form>
	<br>
	<form action = "/students/changePassword">
		<input class = "green_btn medium_btn" title = "Change Password of your account" type = "submit" value = "Change Password">
	</form>
	<br>
	<form action = "/logout">
		<input class = "green_btn medium_btn" title = "Logout" type = "submit" value = "Logout">
	</form>
	
	
</body>
</html>