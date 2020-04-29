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
		response.sendRedirect("adminLogin.jsp");
	}
%>
	<br><br>
	<h1> Hello ${admin} </h1>
	<h2> your id is ${mess_id}  </h2>
	<hr>
	<div class="align_left">
	<form action="/mess/student">
            <input class = "green_btn medium_btn" type="submit" title="If you want to add new Student" value="Manage Student" />
	</form>
	<br>
	<form action="/mess/staff">
		<input class = "green_btn medium_btn" type="submit" title="Add, Remove Employes; pay their salary" value="Manage Employes" />
	</form>
	<br>
	<form action="/mess/inventory">
		<input class = "green_btn medium_btn" type="submit" title="Add, Remove, Update Inventory stock" value="Manage Inventory" />
	</form>
	<br>
	<form action = "/mess/menu">
		<input class = "green_btn medium_btn" type = "submit" title="Manage Menu" value = "Manage Menu">
	</form>
	<br>
	<form action = "/mess/changePassword">
		<input class = "green_btn medium_btn" type = "submit" title="Manage your account" value = "Change Password">
	</form>
	<br>
	<form>
		<input class = "green_btn medium_btn" type = "submit" title="Not available yet" value = "Predict No Of Meals">
	</form>	</div>
	<div class="align_center">
	<form action="/logout" method="POST">
		<input class="green_btn" type="submit" value="Logout">
	</form>
	</div>
	
</body>
</html>