<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
		<style>
		body{
		background-color:black;
		color:white;
		}
		
		input{
		background-color:orangeRed;
		border-radius:100px;
		width:500px;
		height:250px;
		margin-left:100px;
		margin-right:100px;
		margin-top:30px;
		font-size:50px;
		}
		
		h1{
	
		color:OrangeRed;
		font-size:100px;
		}
		
		#title{
		text-align:center;}
		
		</style>
	</head>

	<body>
		<!-- <a href= "addNumbers">Add numbers</a>
		<a href= "multiplyNumbers">Multiply numbers</a>
		<a href= "guessingGame"> Guessing Game</a>
		
		<button onclick="document.location='addNumbers'">Add Numbers</button>
		<button onclick="document.location='multiplyNumbers'">Multiply Numbers</button>
		<button onclick="document.location='guessingGame'">Guessing Game</button>-->
		
		<form action="${pageContext.servletContext.contextPath}/index" method = "post">
		
		<div id="title">
		<h1>Welcome</h1>
			</div>
			<div>
			<input name = "login" type = "submit" value = "Back">
			<input name = "account" type = "submit" value = "Account">
			<input name = "carddatabase" type = "submit" value = "Card Database">
			<input name = "play" type = "submit" value = "Play"> 

			</div>
		
	
		
		</form>
	</body>
</html>
