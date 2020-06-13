<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MealOn Add Staff</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/homepage.css">
</head>
<body>
    <br><br>
    <h1>MealOn</h1>
	<h2>Add Staff</h2>
    <div class="align_center">
		<form action="/mess/staff/add" method="post">
			<input class ="form_data" required="required" type="text" name="name" placeholder="Name"/><br></br>
			<input class ="form_data" required="required" type="number" name="account_no" pattern="[0-9]{16}" placeholder="Account No" /><br></br>
			<input class ="form_data" required="required" type="tel" name="contact"  placeholder="Phone No"/><br></br>
			<input class ="form_data" required="required" type="text" name="address" placeholder="Address"/><br></br>
			<input class ="form_data" required="required" type="number" name="salary" placeholder="Salary"/><br></br>
			<input class="green_btn medium_btn" type="submit" value="Add" />
		</form>
	<br>
    <form action="/mess/staff">
    	<input class = "green_btn medium_btn" type="submit" title="Back" value="Back" />
	</form>
	</div>

</body>
</html>