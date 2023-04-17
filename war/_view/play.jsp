<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Play</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		
		body{
		background-color:black;
		color:OrangeRed
		}
		#title{
		
		text-align:center;}
		h1{
		size:50px;
		}
		input{
		background-color:orangeRed;
		border-radius:100px;
		width:250px;
		height:125px;
		margin-left:100px;
		margin-right:100px;
		margin-top:30px;
		font-size:50px;
		}
		img{
		height:100px;
		width:75px;
	
		
		}
		</style>
		<link href="style.css" rel="stylesheet" type="text/css">
		<script>
			var player1Health = 100;
			var player2Health = 100;
			var turn = 1;
			var round = 1;
			var gameOver = false;

			function playCard() {
				if (gameOver) {
					return;
				}
				
				if (turn == 1) {
					player2Health -= 10;
					if (player2Health <= 0) {
						player2Health = 0;
						gameOver = true;
						alert("Player 1 wins!");
					}
					document.getElementById("player2Health").innerHTML = player2Health;
					turn = 2;
				} else {
					player1Health -= 23;
					if (player1Health <= 0) {
						player1Health = 0;
						gameOver = true;
						alert("Player 2 wins!");
					}
					document.getElementById("player1Health").innerHTML = player1Health;
					turn = 1;
					round++;
					document.getElementById("round").innerHTML = "Round: " + round;
				}
			}
		</script>
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/play" method="post">
		
		<input name = "back" type = "submit" value = "Go back">
		<div id = "title">
		<h1>Choose Number of Players</h1>
		</div>
		<input name = "1p" type = "submit" value = "1 Player">
		<input name = "2p" type = "submit" value = "2 Player">
		
		<br><br>
			<table>
			<tr> 
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/coolwind.jpeg">
			</td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/vader.jpeg">
			</td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/vixon.jpeg">
			</td>				
			</tr>
			
	
		</form>
	</body>
</html>
<!--  <!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Play</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		
		body{
		background-color:black;
		color:OrangeRed
		}
		#title{
		
		text-align:center;}
		h1{
		size:50px;
		}
		
		img{
		height:100px;
		width:75px;
	
		
		}
		</style>
		<link href="style.css" rel="stylesheet" type="text/css">
		<script>
			var turn = 1;
			var round = 1;

			function playCard() {
				if (turn == 1) {
					var health = parseInt(document.getElementById("player2Health").innerHTML);
					health-=10;
					document.getElementById("player2Health").innerHTML = health;
					turn = 2;
				} else {
					var health = parseInt(document.getElementById("player1Health").innerHTML);
					health-=23;
					document.getElementById("player1Health").innerHTML = health;
					turn = 1;
					round++;
					document.getElementById("round").innerHTML = "Round: " + round;
				}
			}
		</script>
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/play" method="post">
		
		<input name = "back" type = "submit" value = "Go back">
		<div id = "title">
		<h1>Fight!</h1>
		</div>
		
		<h2 id="round">Round: 1</h2>
		<br><br>
			<table>
			<tr> 
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/vader.jpeg">
			<p>Health : <span id="player1Health">100</span></p>
			<input type="button" name="attack" value="Play card" onclick="playCard()"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/vixon.jpeg">
				<p>Health : <span id="player2Health">100</span></p>
			</tr>
			</table>
	
		</form>
	</body>
</html>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>Play</title>
	<style type="text/css">
		.error {
			color: red;
		}
		td.label {
			text-align: right;
		}
		body {
			background-color: black;
			color: orangeRed;
		}
		#title {
			text-align: center;
		}
		h1 {
			size: 50px;
		}
		img {
			height: 100px;
			width: 75px;
		}
	</style>
	<link href="style.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		var card1Health = 100;
		var card2Health = 100;

		function playCard() {
			if (card2Health > 0) {
				card2Health -= 10;
				document.getElementById("card2Health").innerHTML = "Health: " + card2Health;
			} else if (card1Health > 0) {
				card1Health -= 10;
				document.getElementById("card1Health").innerHTML = "Health: " + card1Health;
			}
		}
	</script>
</head>

<body>
	<c:if test="${! empty errorMessage}">
		<div class="error">${errorMessage}</div>
	</c:if>

	<form action="${pageContext.servletContext.contextPath}/play" method="post">
		<input name="back" type="submit" value="Go back">
		<div id="title">
			<h1>Fight!</h1>
		</div>

		<h2>Round: </h2>
		<br><br>
		<table>
			<tr>
				<td>
					<img class="card" src="<%=request.getContextPath()%>/Images/vader.jpeg">
					<p id="card1Health">Health: 100</p>
					<input type="button" name="attack" value="Play card" onclick="playCard()">
				</td>
				<td>
					<img class="card" src="<%=request.getContextPath()%>/Images/vixon.jpeg">
					<p id="card2Health">Health: 100</p>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

		 	<table>
			<tr>
			<td>
			<input type="submit" name = "one_player" value="One Player">
			</td>
			
			<td>
			<input type="submit" name = "one_player" value="Two Player">
			</td>
			</tr>
				
				
			</table>
			<input type="submit" name="game" value="Go fight!">-->
		