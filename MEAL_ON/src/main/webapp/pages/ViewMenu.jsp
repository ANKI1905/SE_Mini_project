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
<%	//This prevents browser from saving cache
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP1.1
	response.setHeader("Pragma", "n-cache"); //HTTP 1.0
	response.setHeader("Expires", "0"); //Proxies

	if(session.getAttribute("log") == null) {
		response.sendRedirect("studentLogin.jsp");
	}
%>
    <br><br>
    <h1>MealOn</h1>
    <h2>This Week's Menu</h2>
    <div class="align_center">
    <select onchange="func(this)">
    	<option id = "Sunday">Sunday</option>
    	<option id = "Monday">Monday</option>
    	<option id = "Tuesday">Tuesday</option>
    	<option id = "Wednesday">Wednesday</option>
    	<option id = "Thursday">Thursday</option>
    	<option id = "Friday">Friday</option>
    	<option id = "Saturday">Saturday</option>
    	<option id = "AllDay">This Week</option>
    </select>
    <br>
    
    <!--show all weekly menu of the mess joined by student-->   
	<table border = 1 id="MenuTable" align = "center">
		<tr>
			<td>Day</td>
			<td>Type</td>
			<td>Menu</td>
		</tr>
    <c:forEach var = "i" items="${size}">
    
        <tr>
	        <td class = "dayClass">${weeklyMenuList[i].day}</td>
	        <td>
		        <c:set var = "type" value = "${weeklyMenuList[i].type}" />
		        <c:if test="${type == 'L'}">
		        	Lunch
				</c:if>
				<c:if test="${type == 'D'}">
		        	Dinner
				</c:if>
	        </td>  
	        <td>
	        	<c:forEach var = "menuName" items = "${menuLists[i]}">
	        		${menuName}<br>
	        	</c:forEach>
	        </td>  
    	</tr>
    </c:forEach>
    </table>
    <br>
    <hr>
    <h4>Breakfast/Snacks Items</h4>
    <br>
    <table border = 1 align = "center">
		<tr>
			<td>Dish</td>
			<td>Price</td>
		</tr>
    <c:forEach var = "snack" items="${snacksList}">
        <tr>
	        <td>${snack.name}</td>
	        <td>${snack.price}</td> 
    	</tr>
    </c:forEach>
    </table>
	<br>
<form action="/students/">
    <input class = "green_btn medium_btn" type="submit" title="go to Home" value="Home" />
</form>
</div>
<script>
	var today = new Date();
	var weekday = new Array(7);
	weekday[0] = "Sunday";
	weekday[1] = "Monday";
	weekday[2] = "Tuesday";
	weekday[3] = "Wednesday";
	weekday[4] = "Thursday";
	weekday[5] = "Friday";
	weekday[6] = "Saturday";
	document.getElementById(weekday[today.getDay()]).selected = true;
	var selectTag = document.getElementsByTagName("select")[0];
	func(selectTag);
	function func(select) { 
		var input, filter, table, tr, td, i, txtValue;
		filter = select.value;
		table = document.getElementById("MenuTable");
		tr = table.getElementsByTagName("tr");
		for(i = 0; i < tr.length; i++) {
			td = tr[i].getElementsByTagName("td")[0];
			txtValue = td.textContent;
			if(txtValue.indexOf(filter) > -1 || filter == "This Week") {
				tr[i].style.display = "";	
			}
			else {
				tr[i].style.display = "none";
			}
		}
	}

    // If same return
</script>
</body>
</html>