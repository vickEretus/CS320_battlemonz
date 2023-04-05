<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Game</title>
		
		 <style type="text/css">
		body{
		background-color:black;
		color:white;
		display:flex;
		flex-direction:column;
		align-items:center;
		justify-content:center;
		}
		
		td{
		color:green;
		}
		
		#game_board{
		width:100%;
		height:500px;
		}
		
		#left, #middle, #right{
		width:33.3%;
		}
		
	
		}
		
		h1, h2{
		color:OrangeRed;
		}
		
		
		
		</style>
		
	
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/game" method="post">
		<a id = "back_link" href = "index">Back</a>
			<div id = "health_bars">
				<table>
				
				<tr>
				<td><h2>Team 1 Health: </h2>
				<td><h2>Team 2 Health: </h2>
				</tr>
				
				
				<tr>
				<!-- <td><h2>${Deck.deck_health}</h2></td>
				<td><h2>${Deck.deck_health}</h2></td>-->
				<td> </td>
				
				<td> </td>
				</tr>
				
				
			</table>
				
			</div>
				
			
			
			<div id = "game_board">
			<div id ="left">
			<img>
			<img>
			<img>
			</div>
			
			<div id = "middle">
			<h1>Round ${Game.round}</h1>
			<h1>Player ${Game.currentplayer}'s turn</h1>
			<img>
			<img>
			<input type="submit" name="place" value="Play Card">
			</div>
			
			<div id = "right">
			<img>
			<img>
			<img>
			</div>
			
			</div>
			
			<div>
			<h1>Game status: ${Game.status}</h1>
			</div>
			
		</form>
	</body>
</html>