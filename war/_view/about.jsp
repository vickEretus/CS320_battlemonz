<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Account</title>
		<style type="text/css">
		body{
		background-color:black;
		color:orangeRed;}
		
		#title{
		width:100%;
		text-align:center;
		height:50px;
		}
		
		#info{

		
			margin-left:350px;
			margin-right:200px;
			width:50%;
			height:400px;
			border-radius:50px;
			background-color:orangeRed;
			color:black;
			line-height:75px;
			text-align:center;
		}
		
		#buttons input{
	
		
		background-color:OrangeRed;
		width: 100px;
		height:30px;
		border-radius:20px;
		margin: 0 auto;
    	display: block;
		
		}
		
		#buttons{
		display:flex;
		margin-top:30px;
		justify-content:space-between;
		}
		
		
		</style>
		
		<link href="style.css" rel="stylesheet" type="text/css">
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/account" method="post">
			<div id = "title">
			<h1>Account Information</h1>
			</div>
			
			<div id = "info">
			<h1>
			Username: ${account.username}
			</h1>
			<h1>
			Card 1: ${account.card1}
			</h1>
			<h1>
			Card 2: ${account.card2}
			</h1>
			<h1>
			Card 3: ${account.card3}
			</h1>

			
			
			
		
			
			
			</div>
			
			<br><br>
			
			<div id="buttons">
			<input name = "back" type = "submit" value = "Go back">
			

			
			<input type="Submit" name="logout" value="Logout">
			
			</div>
		</form>
	</body>
</html>