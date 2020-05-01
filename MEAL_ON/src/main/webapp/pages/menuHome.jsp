<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MealOn Inventory Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/homepage.css">
</head>
<body>
    <br><br>
    <h1>MealOn</h1>
	<h2>Manage Inventory</h2>
    <!--show all inventory here and an option to edit them-->   
    <table class="table table-dark table-striped table-hover ">
        <thead class="thead-dark">
			<tr>
				<td>Name</td>
				<td>Mark For Today</td>
				<td>Actions </td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "i" items="${menuList}">
				<tr>
					<td>${i.name}</td>  
					<td>checkbox here</td>  
					<td>
						<button class="btn btn-danger" >Delete</button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
	</table>
<div class="align_center">
<form action="/mess/menu/add/page">
    <input class = "green_btn medium_btn" type="submit" title="Add an item in Menu" value="Add Menu Item" />
</form>
</div>
</body>
</html>