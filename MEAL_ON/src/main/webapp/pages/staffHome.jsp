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
<link rel="stylesheet" type="text/css" href="/css/homepage.css">
</head>
<body>
    <br><br>
    <h1>MealOn</h1>
    <h2>Manage Staff</h2>
    <!--show all mess employes here and an option to edit them-->   
	<table>
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Account Number</td>
			<td>Contact</td>
			<td>Address</td>
		</tr>
    <c:forEach var = "i" items="${staffList}">
        <tr>
	        <td>${i.staffid}</td>
	        <td>${i.name}</td>  
	        <td>${i.accountno}</td>  
	        <td>${i.contact}</td>  
	        <td>${i.address}</td>  
    	</tr>
    </c:forEach>
    </table>
<div class="align_center">
<form action="/mess/staff/add/page">
    <input class = "green_btn medium_btn" type="submit" title="Add an Employee" value="Add Employe" />
</form>
</div>
</body>
</html>