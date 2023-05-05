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
		height:133px;
		width:100px;
	
		
		}
		
		td{
			height:200px;
		width:150px;
	
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
		  var counter = 0;
		  function updateCounter() {
		    var checkboxes = document.getElementsByName('card');
		    counter = 0;
		    for (var i = 0; i < checkboxes.length; i++) {
		      if (checkboxes[i].checked) {
		        counter++;
		      }
		    }
		  }
		  function submitForm() {
		    updateCounter();
		    if (counter !== 3) {
		      alert('Please select exactly three cards.');
		      return false;
		    }
		    return true;
		  }
		  
		  function showCardStats(statsId, imgElement) {
			    var statsDiv = document.getElementById(statsId);
			    if (statsDiv.style.display === 'none') {
			        statsDiv.style.display = 'block';
			        imgElement.style.display = 'none';
			    } else {
			        statsDiv.style.display = 'none';
			        imgElement.style.display = 'block';
			    }
			}

			function hideCardStats(statsId, statsElement) {
			    var statsDiv = document.getElementById(statsId);
			    statsDiv.style.display = 'none';
			    var imgElement = statsElement.previousElementSibling;
			    imgElement.style.display = 'block';
			}
			
		
		</script>
		
			
		
		
		
		
		
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
	<form action="${pageContext.servletContext.contextPath}/carddatabase" method="post">
  <input type="hidden" name="back" value="true">
  <input type="submit" value="Back">
</form>
	
	
	

		
		<form action="${pageContext.servletContext.contextPath}/carddatabase" method="post" onsubmit="return submitForm();">
		
	
	
		
	
		<div>
		<h1>Cards</h1>
		
		</div>
		
		
			<div id = "left">
			
			<table>
			
			
			<tr> 
			
			<td>GRASS</td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Vader.jpeg" onclick="showCardStats('vader-stats',this)">
			<div id="vader-stats" style="display: none;" onclick="hideCardStats('vader-stats', this)">
        		 <p>HP: 90</p>
        		 <p>Attack: 66</p>
    			<p>Defense: 94</p>
    		
    		</div>
    		<input  type="checkbox" name="card" value="vader" value="Choose Card">
			</td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Vixon.jpeg" onclick="showCardStats('vixon-stats',this)">
			<div id="vixon-stats" style="display: none;" onclick="hideCardStats('vixon-stats', this)">
        		 <p>HP: 82</p>
        		 <p>Attack: 73</p>
    			<p>Defense: 95</p>
    		
    		</div>
    		<input type="checkbox" name="card" value="vixon" value="Choose Card"></td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Smokedux.jpeg" onclick="showCardStats('smokedux-stats',this)">
			<div id="smokedux-stats" style="display: none;" onclick="hideCardStats('smokedux-stats', this)">
        		 <p>HP: 95</p>
        		 <p>Attack: 70</p>
    			<p>Defense: 85</p>
    		
    		</div>
    		<input type="checkbox" name="card" value="smokedux" value="Choose Card"></td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Zeus.jpeg"onclick="showCardStats('zeus-stats',this)" >
			<div id="zeus-stats" style="display: none;" onclick="hideCardStats('zeus-stats', this)">
        		 <p>HP: 82</p>
        		 <p>Attack: 76</p>
    			<p>Defense: 92</p>
    		
    		</div>
    		<input type="checkbox" name="card" value="zeus" value="Choose Card"></td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Heathen.jpeg" onclick="showCardStats('heathen-stats',this)">
			<div id="heathen-stats" style="display: none;" onclick="hideCardStats('heathen-stats', this)">
        		 <p>HP: 92</p>
        		 <p>Attack: 70</p>
    			<p>Defense: 88</p>
    	
    		</div>
    		<input type="checkbox" name="card" value="heathen" value="Choose Card"></td>
			</tr>
			
			
			
			<tr>
			<td>FIRE</td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Trance.jpeg" onclick="showCardStats('trance-stats',this)">
			<div id="trance-stats" style="display: none;" onclick="hideCardStats('trance-stats', this)">
        		 <p>HP: 94</p>
        		 <p>Attack: 57</p>
    			<p>Defense: 99</p>
    	
    		</div>
    		<input type="checkbox" name="card" value="trance" value="Choose Card"></td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Nethertalon.jpeg" onclick="showCardStats('nethertalon-stats',this)">
			<div id="nethertalon-stats" style="display: none;" onclick="hideCardStats('nethertalon-stats', this)">
        		 <p>HP: 89</p>
        		 <p>Attack: 71</p>
    			<p>Defense: 90</p>
    	
    		</div>
    		<input  type="checkbox" name="card" value="nethertalon" value="Choose Card"></td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Firebreather.jpeg" onclick="showCardStats('firebreather-stats',this)">
			<div id="firebreather-stats" style="display: none;" onclick="hideCardStats('firebreather-stats', this)">
        		 <p>HP: 88</p>
        		 <p>Attack: 75</p>
    			<p>Defense: 87</p>
    		
    		</div>
    		<input  type="checkbox" name="card" value="firebreather" value="Choose Card"></td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Glowzee.jpeg" onclick="showCardStats('glowzee-stats',this)">
			<div id="glowzee-stats" style="display: none;" onclick="hideCardStats('glowzee-stats', this)">
        		 <p>HP: 87</p>
        		 <p>Attack: 65</p>
    			<p>Defense: 98</p>
    	
    		</div>
    		<input type="checkbox" name="card" value="glowzee" value="Choose Card"></td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Brightsoul.jpeg" onclick="showCardStats('brightsoul-stats',this)">
			<div id="brightsoul-stats" style="display: none;" onclick="hideCardStats('brightsoul-stats', this)">
        		 <p>HP: 81</p>
        		 <p>Attack: 80</p>
    			<p>Defense: 89</p>
    	
    		</div>
    		<input type="checkbox" name="card" value="brightsoul" value="Choose Card"></td>
			</tr>
			
			
			
			<tr>
			<td>WATER</td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Coolwind.jpeg" onclick="showCardStats('coolwind-stats',this)">
			<div id="coolwind-stats" style="display: none;" onclick="hideCardStats('coolwind-stats', this)">
        		 <p>HP: 84</p>
        		 <p>Attack: 67</p>
    			<p>Defense: 99</p>
  
    		</div>
			<input type="checkbox" name="card" value="coolwind" value="Choose Card"></td>
			
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Splashfist.jpeg" onclick="showCardStats('splashfist-stats',this)">
			<div id="splashfist-stats" style="display: none;" onclick="hideCardStats('splashfist-stats', this)">
        		 <p>HP: 86</p>
        		 <p>Attack: 67</p>
    			<p>Defense: 97</p>
    		
    		</div>
    		<input  type="checkbox" name="card" value="splashfist" value="Choose Card"></td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Searvoid.jpeg" onclick="showCardStats('searvoid-stats',this)">
			<div id="searvoid-stats" style="display: none;" onclick="hideCardStats('searvoid-stats', this)">
        		 <p>HP: 93</p>
        		 <p>Attack: 69</p>
    			<p>Defense: 88</p>
    
    		</div>
    		<input  type="checkbox" name="card" value="searvoid" value="Choose Card"></td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Braveface.jpeg" onclick="showCardStats('braveface-stats',this)">
			<div id="braveface-stats" style="display: none;" onclick="hideCardStats('braveface-stats', this)">
        		 <p>HP: 96</p>
        		 <p>Attack: 70</p>
    			<p>Defense: 84</p>

    		</div>
    		<input type="checkbox" name="card" value="braveface" value="Choose Card"></td>
			
			<td><img class ="card" src="<%=request.getContextPath()%>/Images/Poseidon.jpeg" onclick="showCardStats('poseidon-stats',this)">
			<div id="poseidon-stats" style="display: none;" onclick="hideCardStats('poseidon-stats', this)">
        		 <p>HP: 93</p>
        		 <p>Attack: 67</p>
    			<p>Defense: 90</p>
    
    		</div>
    		<input type="checkbox" name="card" value="poseidon" value="Choose Card"></td>
			</tr>
				
				
			</table>
			</div>
			
			<input  type="submit" value="Submit">
			

				</form>
			
			
			<div id ="right">
			
			<h1>
			My Collection
			</h1>
			
			
			
	
			
			
    <div id="chosen-cards">
        <p>Chosen Cards:</p>
        <ul>
    <c:if test="${empty selectedCardNames}">
      <p>No cards selected</p>
    </c:if>
    <c:forEach items="${selectedCardNames}" var="cardName">
      <h1>${cardName}</h1>
    </c:forEach>
  </ul>
   			 </div>

		<form action="${pageContext.servletContext.contextPath}/carddatabase" method="post">
  		<input type="hidden" name="remove" value="true">
  		<input type="submit" value="remove">
		</form>
			
			</div>	
			
		
			
	
			
	</body>
</html>