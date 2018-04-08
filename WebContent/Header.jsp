<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function logout() {
		window.location.href = "./LogoutServlet";
	}
	function callAction(param) {
		if (param == 'a') {
			window.location.href = './AddComponent.jsp';
		} else if (param == 'u') {
			window.location.href = './UpdateComponent.jsp';
		} else if (param == 't') {
			window.location.href = './CreateTransaction.jsp';
		} else if (param == 'd') {
			window.location.href = './GetComponents';
		}
	}
</script>
</head>
<body>
	<div
		style="background: black; height: 100px; padding: 5px; margin: 0; position: fixed; top: 0px; width: 100%">
		<div style="float: left">
			<p style="color: white; padding: 2px; font-size: 150%">LabComponent</p>
			<%
				if ("A".equals(session.getAttribute("userRole"))) {
			%>
			<div style="padding: 2px">
				<button id="add" onclick="callAction('a')">Add Component</button>
				<button id="update" onclick="callAction('u')">Update
					Component</button>
				<button id="transaction" onclick="callAction('t')">Create
					Transaction</button>
				<button id="transaction" onclick="callAction('d')">DashBoard</button>
			</div>
			<%
				}
			%>
		</div>

		<div
			style="float: right; padding: 10px; text-align: right; color: white;">
			<!-- User store in session with attribute: loginedUser -->
			<%
				if (session.getAttribute("username") != null) {
			%>
			Hello, <b><%=session.getAttribute("username")%></b>&nbsp
			<button id="LogOut" onclick="logout()">Logout</button>
			<br />
			<%
				}
			%>
		</div>
	</div>

</body>
</html>
