<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    ${menu_list[0].name}
    <!--show all inventory here and an option to edit them-->   
    <c:forEach items="staffList" var = "i">
         <c:out value = "${i.name}"/><p>
      </c:forEach>
<div class="align_center">
<form action="/mess/inventory/add/page">
    <input class = "green_btn medium_btn" type="submit" title="Add an item in Inventory" value="Add Item" />
</form>
</div>
</body>
</html>