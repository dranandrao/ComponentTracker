<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LabComponents</title>
<style type="text/css">

html, body {
	height: 100%;
	min-width: 1080px;
	min-height: 600px;
	margin: 0px
}

fieldset{
	border: 2px solid whitesmoke;
	border-radius:2px;
	padding:20px;
	
}

legend.legend-bold{
	font: bold 18px Verdana,sans-serif;
	color: white;
	padding: 0.5em 4em;
	border: 2px solid grey;
	text-align: center;
}

label{
	display: inline-block;
	text-align: left;
	width: 25%;
}

div#container {
	overflow:hidden;
	background-image: url('MU.jpeg');
    background-size: 100% 100%;
    height:100%;
    width:100%;
	display:flex;
	justify-content:center;
	
}

div#loginBox {	
	align-self: center;
	
	background-color: #32363a;
	color: white;
	box-sizing:border-box;	
	border: 1px solid black;
	border-radius: 2px;
	box-shadow: 2px 4px 8px 0 rgba(0, 0, 0, 0.3);
	padding: 10px 20px;
    height: 255px;
    width:500px;
        
}

div#footer2 {
	background-color:lightgrey;
	font-family: Verdana,sans-serif;
	border: .5px solid whitesmoke;
	border-radius:2px;
	padding: 10px 20px;
	max-height:auto;
	max-width:auto;
}

input.submit {
	background-color: grey;
	padding: 5px 10px;
	color: white;
	display: inline:block;
	border-radius:4px;
	border: 1px solid whitesmoke;
	transition-duration:0.4s;
}

input.submit:hover {
	background-color: lightgrey;
	color:black;
}

input.theinput{
	font-family: Verdana,sans-serif;
	color:black;
	width:50%;
	boxsizing: border-box;
	border:1px solid grey;
	border-radius:4px;
	padding: 5px 10px;
}

input.theinput:hover {
	background-color: gainsboro;
}

</style>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<div id="container">
	
	<!-- Login Container -->
		<div align="center" id="loginBox">
			<form action="UserAuthenticate" method="post" id="userform">
				<fieldset style= "margin:auto text-align:center">
				<legend class="legend-bold" >Login</legend>
					<div>					
						<label>Username:</label>
						<input class="theinput" type="text" placeholder= "Enter username" name="username" required/>
					</div>
					<br>
					<div>
						<label>Password:</label>
						<input class="theinput" type="password" placeholder = "Enter password" name="password" required/>
					</div>				
					<br>
					<input class="submit" type="submit" value="Login"/> 
					
				</fieldset>
				
			</form>
			<br>
	  	</div>
	</div>
	<jsp:include page="_footer.html"></jsp:include>
</body>
</html>
