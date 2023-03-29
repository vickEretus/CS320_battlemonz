<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
		<!-- <a href= "addNumbers">Add numbers</a>
		<a href= "multiplyNumbers">Multiply numbers</a>
		<a href= "guessingGame"> Guessing Game</a>
		
		<button onclick="document.location='addNumbers'">Add Numbers</button>
		<button onclick="document.location='multiplyNumbers'">Multiply Numbers</button>
		<button onclick="document.location='guessingGame'">Guessing Game</button>-->
		
		<form action="${pageContext.servletContext.contextPath}/index" method = "post">
			<div>
			<input name = "account" type = "submit" value = "Account">
			<input name = "carddatabase" type = "submit" value = "Card Database">
			<input name = "play" type = "submit" value = "Play"> 
			</div>
		
		</form>
	</body>
</html>
