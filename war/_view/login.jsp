<!DOCTYPE html>

<html>
	<head>
		<title>Login view</title>
	</head>

	<body>
		<!-- <a href= "addNumbers">Add numbers</a>
		<a href= "multiplyNumbers">Multiply numbers</a>
		<a href= "guessingGame"> Guessing Game</a>
		
		<button onclick="document.location='addNumbers'">Add Numbers</button>
		<button onclick="document.location='multiplyNumbers'">Multiply Numbers</button>
		<button onclick="document.location='guessingGame'">Guessing Game</button>-->
		
		<form action="${pageContext.servletContext.contextPath}/login" method = "post">
			<table>
				<tr>
					<td class="label"> Username </td>
					<td><input type="text" name="username" size="12"  /></td>
				</tr>
				<tr>
					<td class="label">Password</td>
					<td><input type="text" name="password" size="12" /></td>
				</tr>
			
			</table>
			<input type="Submit" name="submit" value="Submit!">
		</form>
	</body>
</html>
