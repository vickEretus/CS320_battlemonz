<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Card Game</title>
		<style>
		body{
		background-color:black;
		color:OrangeRed;}
		img{
		height:100px;
		width:75px;
		}
		
		</style>
		
		<script>
		function checkSelection() {
			  var cardOne = document.getElementById("cardOne").value;
			  var cardTwo = document.getElementById("cardTwo").value;

			  if (cardOne == "" || cardTwo == "") {
			    alert("Please select both cards before proceeding.");
			    return false;
			  }

			  document.getElementById("cardOneIndex").value = document.getElementById("cardOne").selectedIndex;
			  document.getElementById("cardTwoIndex").value = document.getElementById("cardTwo").selectedIndex;

			  return true;
			}
		</script>
	</head>
	<body>
		<div style="float: left; width: 30%;">
			<h2>Deck One</h2>
			<ul>
			
	
				<li><img src="${pageContext.request.contextPath}/Images/${d1c1name}.jpeg"/>
				${d1c1name}
				${d1c1health}</li>
				<li><img src="${pageContext.request.contextPath}/Images/${d1c2name}.jpeg"/>
				${d1c2name}
				${d1c2health}</li>
				<li><img src="${pageContext.request.contextPath}/Images/${d1c3name}.jpeg"/>
				${d1c3name}
				${d1c3health}</li>
			</ul>
			<p>Health: ${deck_one_health}</p>
			<p>Round Damage: ${damage_two} </p>
		</div>
		
		<div style="float: right; width: 30%;">
			<h2>Deck Two</h2>
			<ul>
				<li><img src="${pageContext.request.contextPath}/Images/${d2c1name}.jpeg"/>
				${d2c1name}
				${d2c1health}
				</li>
				<li><img src="${pageContext.request.contextPath}/Images/${d2c2name}.jpeg"/>
				${d2c2name}
				${d2c2health}</li>
				<li><img src="${pageContext.request.contextPath}/Images/${d2c3name}.jpeg"/>
				${d2c3name}
				${d2c3health}</li>
			</ul>
			<p>Health: ${deck_two_health}</p>
			<p>Round Damage: ${damage_one} </p>
		</div>
		
		<div style="margin: 0 auto; width: 30%;">
			<h2>Selected Cards</h2>
			<form action="${pageContext.servletContext.contextPath}/game" method="post" onsubmit="return checkSelection()">
				<select id = "cardOne" name="card_one">
				  <option value="">Select card one</option>
					<option value="0">${d1c1name}</option>
					<option value="1">${d1c2name}</option>
					<option value="2">${d1c3name}</option>
				</select>
				
				<select id = "cardTwo" name="card_two">
				  <option value="">Select card two</option>
					<option value="0">${d2c1name}</option>
					<option value="1">${d2c2name}</option>
					<option value="2">${d2c3name}</option>
				</select>
				
				  <input type="hidden" id="cardOneIndex" name="card_one_index" value=""/>
  				<input type="hidden" id="cardTwoIndex" name="card_two_index" value=""/>
				
				
				<input id = "fightButton" type="submit" name="fight" value="Fight"/>
			</form>
			
			 <c:choose>
        <c:when test="${game_over}">
            <p>The game is over.</p>
        </c:when>
        <c:otherwise>
            <p>Keep playing!</p>
        </c:otherwise>
    </c:choose>

   
			
		
			<p>Round: ${game.round}</p>
		</div>
	</body>
</html>
