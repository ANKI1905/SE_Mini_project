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
<script src="/js/index.js"></script>

</head>
<body>
    <br><br>
    <h1>MealOn</h1>
	<h2>Manage Menu</h2>
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
						<!--there is some issue here in showing menu_id so deleting by name for now-->
						<button class="btn btn-danger" onclick="removeMenu('${i.name}')">Delete</button>
					</td>
				</tr>
			</c:forEach>
			</tbody>
	</table>
<div class="align_center">
</div>
<br><br<br>
<br><br>
<hr>
<h2>Add Menu</h2>
<div class="align_center">
	<form action="/mess/menu/add" method="post">
		<input class ="form_data" required="required" type="text" name="name" placeholder="Name"/><br></br>
		<input class="green_btn medium_btn" type="submit" value="Add" />
	</form>
	<br><br><br>
</div>
</body>
</html>