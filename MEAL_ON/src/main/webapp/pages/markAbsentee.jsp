<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Date" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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
    <h2>Mark Absentee</h2>
    <div class="w3-bar w3-black">
		<button class="w3-bar-item w3-button green_btn medium_btn" onclick="openTab('weeksAbsentee')">Weekly</button>
		<button class="w3-bar-item w3-button green_btn medium_btn" onclick="openTab('bulkAbsentee')" title="Mark absentee for a long time">Long period</button>
	</div>
    <div class="align_center">
    <div id="weeksAbsentee" class="absentee">
     <table>
   		<thead class = "white">
   			<tr>
   				<th>Day</th>
   				<th>Lunch</th>
   				<th>Dinner</th>
   			</tr>
   		</thead>
   		<tr>
   			<td>
   				 <!--<c:set var="today" value="<%=new Date()%>"/>
					<c:set var="tomorrow" value="<%=new Date(new Date().getTime() + 60*60*24*1000)%>"/>
					Today: <fmt:formatDate type="date" value="${today}" pattern="d"/>   
					Tomorrow: <fmt:formatDate type="date" value="${tomorrow}" pattern="d"/>
					--
					--					Mark Absentee of current week
					---------------------------------------------------------------------
					|					|  Day  |  Lunch  |  Dinner  |					|
					---------------------------------------------------------------------
					|					| Thurday |	| |	  |    | |   |					|
					|					| Friday  |	| |	  |    | |   |					|
					|					|Saturday |	| |	  |    | |   |					|
					|					| Sunday  |	| |	  |    | |   |					|
					|					| Monday  |	| |	  |    | |   |					|
					|					| Tuesday |	| |	  |    | |   |					|
					|					|Wednesday|	| |	  |    | |   |					|
					---------------------------------------------------------------------
					--
					--
					-->
					   		
   			</td>
   			<td>
   				<input type="checkbox" name="lunch">
   			</td>
   			<td>
   				<input type="checkbox" name="dinner">   				
   			</td>
   		</tr>
   	</table>
    </div>
    <div id="bulkAbsentee" class="absentee white" style="display:none">
    *select Lunch/Dinner to mark absentee
    <form action = "/students/markAbsenteeData" method = "GET">
    	<table align = "center">
	    	<tr>
		    	<td></td>
		    	<td></td>
		    	<td>Lunch</td>
		    	<td>Dinner</td>
		    	<td></td>
	    	</tr>
	    	<tr>
		      	<td><input type="date" name="from" value="From" require/></td>
		    	<td><input type="date" name="to" value="To" required/></td>
		    	<td><input type="checkbox" name="lunch" value="Lunch"/></td>
		    	<td><input type="checkbox" name="dinner" value="Dinner"/></td>
		    	<td><input class="green_btn medium_btn" type="submit" value="Mark Absentee"/></td>
	    	</tr>
    	</table>
    </form>
    </div>
    
	

    <br>
    Your marked absentees
    <table class="table table-dark table-striped table-hover">
    		<c:forEach var="record" items="${absenteeRecords}">
    			<tr>
    				<td>
    					${record.from}
    				</td>
    				<td>
    					${record.to}
    				</td>
    				<td>
    					<c:set var = "type" value = "${record.type}" />
				        <c:if test="${type == 'L'}">
				        	Lunch
						</c:if>
						<c:if test="${type == 'D'}">
				        	Dinner
						</c:if>
    				</td>
    			</tr>
    		</c:forEach>
    </table>
    <br>
    <form action="/students/">
    	<input class = "green_btn medium_btn" type="submit" title="go to Home" value="Home" />
	</form>
   </div>
   
   <script>
		function openTab(tabName) {
			var i;
			var x = document.getElementsByClassName("absentee");
			for (i = 0; i < x.length; i++) {
				x[i].style.display = "none";
			}
			document.getElementById(tabName).style.display = "block";
		}
   </script>
</body>
</html>