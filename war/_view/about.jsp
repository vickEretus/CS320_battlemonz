<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>About</title>
		<style type="text/css">
		body{
		background-color:black;
		color:orangeRed;}
		
		#title{
		width:100%;
		text-align:center;
		height:50px;
		}
		
		h1{
	
		color:OrangeRed;
		font-size:100px;
		text-align:center;
		}
		
		h2{
		color:OrangeRed;
		font-size:50px;
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
			<h1>About the Game</h1>
			</div>
			
			<div id = "info">
			

			<p>
			Battle
			</p>
			
			
		
			
			
			</div>
			
			<br><br>
			
			<div id="buttons">
			<input name = "back" type = "submit" value = "Go back">
			

			
			
			
			</div>
		</form>
	</body>
</html>