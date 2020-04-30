<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>MealOn Admin Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/css/homepage.css">
</head>
<body>
	<br><br>
	<h1>MealOn</h1>
	<h2>Admin Login</h2>
	<div class="align_center">
		<form action="adminauth" method="post">
			<input class ="form_data" required="required" type="number" name="mess_id" placeholder="Mess ID"/>
			<br><br>
			<input class ="form_data" required="required" type="password" name="Password" placeholder="password" />
			<br></br>
			<input class="green_btn medium_btn" type="submit" value="Login" />
		</form>
		<br><br>
		<form action="/newadmin" method="post">
			<input class="green_btn medium_btn" type="submit" value="New Admin Account" />
			<br></br>
		</form>>
	</div>
</body>
</html>










<!-- <table>
    <c:forEach items="${userRecords}" var="user">
        <tr>
            <td>${user.user_first_name}</td>
            <td>${user.user_middle_name}</td>
        </tr>
    </c:forEach>
</table>

 -->
