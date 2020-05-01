<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mess Students</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script src="/js/index.js"></script>
<link rel="stylesheet" type="text/css" href="/css/homepage.css">
</head>
<body>
    <%	//This prevents browser from saving cache
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP1.1
	response.setHeader("Pragma", "n-cache"); //HTTP 1.0
	response.setHeader("Expires", "0"); //Proxies
	if(session.getAttribute("log") == null) {
		response.sendRedirect("adminLogin.jsp");
	}
%>
<br><br>
<h1>MealOn</h1>
<h2>Manage Students</h2>
<h3>{status}</h3>
<!--show all mess students here and an option to edit them-->   
<table class="table table-dark table-striped table-hover ">
    <thead class="thead-dark">
        <tr>
            <td>MIS</td>
            <td>Name</td>
            <td>Phone Number</td>
            <td>Bill</td>
            <td>Actions </td>
        </tr>
    </thead>
    <tbody>
        <c:forEach var = "i" items="${studentList}">
            <tr>
                <td>${i.mis}</td>
                <td>${i.name}</td>  
                <td>${i.contact}</td>  
              
              <td>0</td>  

                <td>
                    <button class="btn btn-danger" >Delete</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
</table>
<div class="align_center">
    <form action="/mess/newstudent">
        <input class = "green_btn medium_btn" type="submit" title="Add an Student" value="Add Student" />
    </form>
</body>
</html>