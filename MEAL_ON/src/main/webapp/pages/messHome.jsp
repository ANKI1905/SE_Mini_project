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
	<br><br>
	<h1> Hy ${admin} </h1>
	<h2> your id is ${mess_id}  </h2>
	<hr>
	<div class="align_left">

	<form action="/mess/newstudent">
            <input class = "green_btn medium_btn" type="submit" title="If you want to add new Student" value="Add Student" />
	</form>
	<br>
	<form action="/mess/staff">
		<input class = "green_btn medium_btn" type="submit" title="Add, Remove Employes; pay their salary" value="Manage Employes" />
	</form>
	<br>
	<form action="/mess/inventory">
		<input class = "green_btn medium_btn" type="submit" title="Add, Remove, Update Inventory stock" value="Manage Inventory" />
	</form>
	<br>	<button class="green_btn medium_btn" value="HII">Predict No. Of Meals</button><br><br>
	<button class="green_btn medium_btn" value="HII">Menu</button><br><br>
	<button class="green_btn medium_btn" value="HII">Help</button><br><br>
	</div>
	<div class="align_center">
	<form action="/logout" method="POST">
		<input class="green_btn" type="submit" value="Logout">
	</form>
	</div>
	
</body>
</html>