<!DOCTYPE html>

<html>
	<head>
		<title>Login view</title>
		<style>
		
		body{
		background-color:black;
		color:white;
		display:flex;
		flex-direction:column;
		align-items:center;
		justify-content:center;
		}
		
		#title{
		width: 100%;
		height: 200px;
		text-align:center;}
		
		h1{
		font-size:50px;
		color:OrangeRed;
		font-family: }
		
		#prompt_box{
		font-size:30px;
		text-align:center;
		width:100%;
		color:OrangeRed;
		height: 200px;
		
		
		}
		
		#guest{
		font-size:20px;
		
		}
		
		a:visited{
		color:OrangeRed;
		cursor:pointer;}
		
		a:hover{
		color:purple;
		cursor:pointer;}
		
		
		#create_button input{
		background-color:OrangeRed;
		height:50px;
		width:300px;
		border-radius:25px;
		font-size:25px;
		}
		
		#t{
		color:white;}
		
		td{
		
		text-align:center;
		
		}
		
		td input{
		
		width:200px;
		height:25px;
		}
		
		</style>
		<script>
		function validateForm() {
		  var username = document.getElementById("username").value.trim();
		  var password = document.getElementById("password").value.trim();
		  
		  if (username == "" || password == "") {
		    alert("Please fill in all fields.");
		    return false;
		  }
		  
		  if (/\s/.test(username) || /\s/.test(password)) {
		    alert("Please remove any spaces in the username or password.");
		    return false;
		  }
		  
		  return true;
		}
				
		</script>
	</head>

	<body>
	
		<form action="${pageContext.servletContext.contextPath}/login" method = "post">
			<div id = "title">
			<h1>BATTLEMONSTERZ</h1>
			<h2>Get ready to FIGHT! But first...</h2>
			
			</div>
			
			<div id = "prompt_box">
			<table>
				<tr>
					<td class="label">Username </td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="text" name="username" id="username" size="12" value = "${User.username}" /></td>
				</tr>
			
				<tr>
	
					<td  class="label">Password</td>
					<td> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input type="text" name="password" id="password" size="12" value = "${User.password}"/></td>
				</tr>
				
			</table>
			<br><br>
			
			<div id = "create_button">
			<input type="Submit" name="login" value="Create Account / Login" onclick="return validateForm()">
			
			</div>
			
			<br>
		
			
			</div>
		
			
			
			
			
		</form>
	</body>
</html>
