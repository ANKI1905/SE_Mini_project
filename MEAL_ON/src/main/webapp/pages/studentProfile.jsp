<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MealOn Staff Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="/js/index.js"></script>
<link rel="stylesheet" type="text/css" href="/css/homepage.css">
</head>
<body>
    <br><br>
    <h1>MealOn</h1>
	<h2>My Profile</h2>
	<div class = "white align_center">
		${name}
		<br>
		${mis}
		<br>
		Mess ID: ${messid}
	</div><br>
	<div class="align_center">
	    <form action="/students/">
	    	<input class = "green_btn medium_btn" type="submit" title="go to Home" value="Home" />
		</form>
	</div>
</body>
</html>