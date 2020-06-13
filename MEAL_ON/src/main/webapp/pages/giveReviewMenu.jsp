<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MealOn Staff Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/homepage.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="/js/index.js"></script>
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
    <h2>Give Reviews and Ratings</h2>
    <div class="align_center">
    <form action = "/students/reviewRatingData" method = "GET">
    <table class="table table-dark table-striped table-hover ">
    	<thead class="thead-dark">
			<tr>
				<th>Menu</th>
				<th>Ratings</th>
				<th>Review</th>
			</tr>
		</thead>
    <c:forEach var="menu" items="${menuLists}">
    
        <tr>
	        <td>${menu}</td>
	        <td>
			    
		        <div class="rating">
		            <input id="star5${menu}" name="star${menu}" type="radio" value="5" class="radio-btn hide"/>
		            <label for="star5${menu}" title="Awesome - 5 stars">&#10038</label>
		            <input id="star4${menu}" name="star${menu}" type="radio" value="4" class="radio-btn hide"/>
		            <label for="star4${menu}" title="Pretty good - 4 stars">&#10038</label>
		            <input id="star3${menu}" name="star${menu}" type="radio" value="3" class="radio-btn hide"/>
		            <label for="star3${menu}" title="Meh - 3 stars">&#10038</label>
		            <input id="star2${menu}" name="star${menu}" type="radio" value="2" class="radio-btn hide"/>
		            <label for="star2${menu}" title="Kinda bad - 2 stars">&#10038</label>
		            <input id="star1${menu}" name="star${menu}" type="radio" value="1" class="radio-btn hide"/>
		            <label for="star1${menu}" title="Sucks big time - 1 star">&#10038</label>
		        </div>
			    
	        </td>  
	        <td>
	        	<input type="text" name="review${menu}"/>
	        </td>
	     </tr>
	     
	 </c:forEach>
    </table>
    <input class="green_btn medium_btn" type="submit" value="Give feedback">
    </form>
    <br>
    <form action="/students/">
    	<input class = "green_btn medium_btn" type="submit" title="go to Home" value="Home" />
	</form>
   </div>
</body>
</html>