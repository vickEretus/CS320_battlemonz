<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Card Database</title>
		
		
		<style>
		
		body{
		background-color:black;
		color:OrangeRed;
		}
		
		input{
		background-color:orangeRed;
		}
		
		img{
		height:100px;
		width:75px;
	
		
		}
		
		td{
			height:150px;
		width:112.5px;
	
		}
		
		#left{
		
		width:50%;
		float:left;}
		
		#right{
		
		width:50%;
		float:right;}
		
		.card {
  
  
    cursor: pointer;
  }
  
  
  
  .selected {
  border: 20px solid red;
   background-color: red;
}			

  
		</style>
		
			<script>
			 function chooseCard(card) {
			        var chosenCards = document.getElementById("chosen_cards");
			        var newCard = document.createElement("div");
			        newCard.innerHTML = card;
			        chosenCards.appendChild(newCard);
			      }
			      function removeCard() {
			        var chosenCards = document.getElementById("chosen_cards");
			        var lastCard = chosenCards.lastChild;
			        if (lastCard) {
			          chosenCards.removeChild(lastCard);
			        }
			      }
		</script>
		
		
		
		
		
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
	
		<form action="${pageContext.servletContext.contextPath}/carddatabase" method="post">
		
		
	
		
		<input name = "back" type = "submit" value = "Go back">
		<div>
		<h1>Cards</h1>
		
		</div>
		
		
			<div id = "left">
			
			<table>
			<tr> 
			<td>GRASS</td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/vader.jpeg">
			<input onclick="chooseCard('vader')" type="button" name="vader" value="Choose Card"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/vixon.jpeg">
			<input onclick="chooseCard('vixon')" type="submit" name="vixon" value="Choose Card"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/smokedux.jpeg">
			<input onclick="chooseCard('smokedux')" type="submit" name="smokedux" value="Choose Card"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/zeus.jpeg">
			<input onclick="chooseCard('zeus')" type="submit" name="zeus" value="Choose Card"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/heathen.jpeg">
			<input onclick="chooseCard('heathen')" type="submit" name="heathen" value="Choose Card"></td>
			</tr>
			
			
			<tr>
			<td>FIRE</td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/trance.jpeg">
			<input onclick="chooseCard('trance')" type="submit" name="trance" value="Choose Card"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/nethertalon.jpeg">
			<input onclick="chooseCard('nethertalon')" type="submit" name="nethertalon" value="Choose Card"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/firebreather.jpeg">
			<input onclick="chooseCard('firebreather')" type="submit" name="firebreather" value="Choose Card"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/glowzee.jpeg">
			<input onclick="chooseCard('glowzee')" type="submit" name="glowzee" value="Choose Card"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/brightsoul.jpeg">
			<input onclick="chooseCard('brightsoul')" type="submit" name="brightsoul" value="Choose Card"></td>
			</tr>
			
			<tr>
			<td>WATER</td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/coolwind.jpeg">
			<input onclick="chooseCard('coolwind')" type="submit" name="coolwind" value="Choose Card"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/splashfist.jpeg">
			<input onclick="chooseCard('splashfist')" type="submit" name="splashfist" value="Choose Card"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/searvoid.jpeg">
			<input onclick="chooseCard('searvoid')" type="submit" name="searvoid" value="Choose Card"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/braveface.jpeg">
			<input onclick="chooseCard('braveface')" type="submit" name="braveface" value="Choose Card"></td>
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/poseidon.jpeg">
			<input onclick="chooseCard('poseidon')" type="submit" name="poseidon" value="Choose Card"></td>
			</tr>
				
				
			</table>
			</div>
			
			
			
			<div id ="right">
			
			<h1>
			My Collection
			</h1>
			
			
			
	
			
			<div id ="chosen_cards">
		
		
	
    		<button onclick="removeCard()">Remove Card</button>
			
			
			
			
			</div>
			</div>	
			
		</form>
			
	</body>
</html>