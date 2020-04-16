<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Admin page</title>
</head>
<body>

<h2>Welcome to spring security demo!!.</h2>

</body>

<h2>Welcome to Admin page!!</h2>

<br>
<a href="${pageContext.request.contextPath}/">Back to home page</a>
<br><br>

<form:form
		action="${pageContext.request.contextPath}/logout" method="POST">
		
		<input type="submit" value="logout">
</form:form>

</html>