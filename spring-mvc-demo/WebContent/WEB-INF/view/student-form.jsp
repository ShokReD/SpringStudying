<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration Form</title>
	</head>
	
	<body>
	<!-- Here, when we show modelAttribute, then our object, 
	which we carry here will be linked to this jsp file  -->
		<form:form action="processForm" modelAttribute="student">
			First name: <form:input path="firstName"/>
			Last name: <form:input path="lastName"/>
			
			<br>
			
			Country: 
			<form:select path="country">
				<form:option value="USA" label="USA"/>
				<form:option value="England" label="England"/>
				<form:option value="France" label="France"/>
				<form:option value="Russia" label="Russia"/>
			</form:select>
			
			<br>
			
			Favorite language:
			Java <form:radiobutton path="favoriteLanguage" value="Java" />
			C# <form:radiobutton path="favoriteLanguage" value="C#" />
			PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
			Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />
			
			<br>
			
			Operating Systems:
			Linux: <form:checkbox path="OperatingSystems" value="Linux"/>
			MacOS: <form:checkbox path="OperatingSystems" value="MacOS"/>
			Windows: <form:checkbox path="OperatingSystems" value="Windows"/>
			
			<br>
			
			<input type="submit" value="Submit">
		</form:form>
	</body>
</html>