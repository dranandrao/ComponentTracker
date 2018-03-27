<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>

.spacer
{
    width: 100%;
    height: 95px;
}

html, body {
	height: 100%;
	min-width: 1080px;
	min-height: 600px;
	margin: 0px
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="spacer">
    &nbsp;
</div>
<jsp:include page="AddComponentForm.html"/>
<jsp:include page="Footer.html"/>
</body>
</html>
