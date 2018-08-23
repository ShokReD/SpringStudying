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
			Country: 
			<form:select path="country">
				<form:option value="USA" label="USA"/>
				<form:option value="England" label="England"/>
				<form:option value="France" label="France"/>
				<form:option value="Russia" label="Russia"/>
			</form:select>
			
			<form:select path="country">
				<form:options items="${student.countryOptions}"/>
			</form:select>
			
			<input type="submit" value="Submit">
		</form:form>
	</body>
</html>