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
		margin-left:50px;
		margin-right:0px;
		margin-top:-20px;
		font-size:50px;
		}
		
		img{
		height:100px;
		width:75px;		
		}
		
		lmargin {
  		float: left;
  		padding: 20px;
  		width: 20%;
  		height: 500px;  		
		}
		1player {
  		float: left;
  		padding: 20px;
  		width: 30%;
  		height: 500px;
    	}
    	2player {
  		float: left;
  		padding: 20px;
  		width: 30%;
  		height: 500px;  		
		}		
		rmargin {
  		float: left;
  		padding: 20px;
  		width: 20%;
  		height: 500px;	
		}
		</style>
		<link href="style.css" rel="stylesheet" type="text/css">
		
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
		<li><lmargin>
		</lmargin>
		<player1>
		<input name = "1player" type = "submit" value = "1 Player">
		<img class ="card" src="<%=request.getContextPath()%>/Images/coolwind.jpeg">
		</player1>
		<player2>
		<input name = "2player" type = "submit" value = "2 Player">
		<img class ="card" src="<%=request.getContextPath()%>/Images/vader.jpeg">
		<img class ="card" src="<%=request.getContextPath()%>/Images/vixon.jpeg">
		</player2>
		<rmargin>
		</rmargin></li>
		
		
		
			
	
		</form>
	</body>
</html>
	