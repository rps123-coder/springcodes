<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
	<style>
	  .error{color:red}
	</style>
</head>

<body>

	<form:form action="displayForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		
		<br><br>
	
		Last name (*): <form:input path="lastName" />
		<form:errors path="lastName" cssClass="error"/>	
		<br><br>
		
		Free Passes (*): <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error"/>	
		<br><br>
		
		Course Code (*): <form:input path="courseCode" />
		<form:errors path="courseCode" cssClass="error"/>	
		<br><br>
	
		Country:

	    <form:select path="country"> 
	     <form:options items="${theCountryOptions}" />
	    </form:select>
    		
				
		<br><br>

		Favorite Language:
		
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />

		<br><br>

		Operating Systems:
		
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
		MS Windows <form:checkbox path="operatingSystems" value="MS Window" />

		<br><br>
	
		<input type="submit" value="Submit" />
	
	</form:form>

 <i> Note: Fill out the Form . (*) means required.</i>
</body>

</html>












