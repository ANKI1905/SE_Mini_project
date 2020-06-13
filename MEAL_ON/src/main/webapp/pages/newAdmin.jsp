<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>MealOn Admin SignUp</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/css/homepage.css">


</head>
<body>
	<br><br>
	<h1>MealOn</h1>
	<h2>Admin Signup</h2>
	<div class="align_center">
		<form action="/admin/signin" method="post">
			<input class ="form_data" required="required" type="text" name="name" placeholder="Mess Name"/><br></br>
			<br>
			<input class ="form_data" required="required" type="password" name="password" placeholder="password" /><br></br>
            <br>
            <input class ="form_data" required="required" type="password" name="confirm_password" placeholder="confirm password" /><br></br>
            <br>
            <input class ="form_data" required="required" type="text" name="messadmin" placeholder="Admin Name"/><br></br>
			<br>
			<input class="green_btn medium_btn" type="submit" value="Signup" />
		</form>
		<br><br><br>
	</div>
</body>
</html>