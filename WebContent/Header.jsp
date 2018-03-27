<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function logout(){
	window.location.href = "./LogoutServlet";
}
</script>
</head>
<body>
<div
	style="background: rgba(0, 0, 0, 0.78); height: 55px; padding: 5px; margin: 0; position: fixed; top: 0px; width: 100%">
	<div style="float: left">
		<h2 style="color: white;">LabComponent</h2>
	</div>

	<div
		style="float: right; padding: 10px; text-align: right; color: white;">

		<!-- User store in session with attribute: loginedUser -->
		Hello <b><%= request.getAttribute("username") %></b>&nbsp
		<button id="LogOut" onclick="logout()">LogOut</button>
		<br />

	</div>

</div>

</body>
</html>
