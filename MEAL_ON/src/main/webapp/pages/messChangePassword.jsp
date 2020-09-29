<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>MealOn Student Login</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
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
	<h1>MealOn</h1>
	<h2>Change Password</h2>
	<h3>${status}</h3>
	<div class="align_center">
		<form action = "/mess/passwordChangeUpdate" method = "POST">
			<p style = "color:white">Old Password</p><input type = "password" name = "oldpass" required/>
			<p style = "color:white">New Password</p><input type = "password" name = "newpass" required/>
			<p style = "color:white">Confirm Password</p><input type = "password" name = "newpass1" required/>
			<br><br>
			<input class = "green_btn medium_btn" type = "Submit" value = "change" onclick="checkPassword(form)"/>
		</form>
		<br><br>
		<br><br>

		<form action="/mess/">
			<input class = "green_btn medium_btn" type="submit" title="go to Home" value="Home" />
		</form>
	</div>
	<script>
	function checkPassword(form) { 
		oldpassword = form.oldpass.value;
        password1 = form.newpass.value; 
        password2 = form.newpass1.value; 
		if(oldpassword == '')
			alert("Please enter your current password");
        // If password not entered 
        if (password1 == '') 
            alert ("Please enter Password"); 
              
        // If confirm password not entered 
        else if (password2 == '') 
            alert ("Please enter confirm password"); 
              
        // If Not same return False.     
        else if (password1 != password2) { 
            alert ("Password did not match: Please try again...") 
            return false; 
        } 

        // If same return True. 
        else{ 
            return true; 
        } 
    } 
	</script>
</body>
</html>