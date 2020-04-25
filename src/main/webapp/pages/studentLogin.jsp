<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>MealOn Student Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/css/homepage.css">

</head>
<body>
	<br><br>
	<h1>MealOn</h1>
	<h2>Student Login</h2>
	<h2>${message}</h2>
	<br>
	<div class="align_center">
		<form action="studentauth" method="post">
			<input class ="form_data" required="required" type="number" name="mis" placeholder="mis" maxLength ="9" />
			<br></br>
			<input class ="form_data" required="required" type="password" name="Password" placeholder="password" /><br></br>
			<br></br>
			<input class="green_btn medium_btn" type="submit" value="Login" />
		</form>
	</div>
</body>
</html>