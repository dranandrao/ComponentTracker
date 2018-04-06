<%@page import="com.beans.Component"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dash-Board</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: left;
}

.spacer {
	width: 100%;
	height: 120px;
}

html, body {
	height: 100%;
	min-width: 1080px;
	min-height: 600px;
	margin: 0px
}
</style>
</head>

<jsp:include page="Header.jsp" />
<div class="spacer">&nbsp;</div>
<body>
	<div>
		<a href="GetContents"><input type="button"
			value="Components Available"></a>
	</div>

	<br>
	<h3>Components Borrowed</h3>
	<table>
		<tr>
			<th>Registration number</th>
			<th>Component ID</th>
			<th>Quantity</th>
			<th>Faculty</th>
			<th>Borrow Date</th>
		</tr>
		<c:forEach items="${transactions}" var="tran" varStatus="loop">
			<tr>
				<td><c:out value="${tran.getUniversity_number()}" /></td>
				<td><c:out value="${tran.getComponent_id()}" /></td>
				<td><c:out value="${tran.getQuantity()}" /></td>
				<td><c:out value="${tran.getFaculty()}" /></td>
				<td><c:out value="${tran.getBorrow_date()}" /></td>

			</tr>
		</c:forEach>
	</table>

</body>
<div class="spacer">&nbsp;</div>
<jsp:include page="Footer.html" />
</html>