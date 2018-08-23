<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<title>Student Confirmation</title>
	</head>
	<body>
		The student is confirmed: <br> 
		First name: ${student.firstName} <br>
		Last name: ${student.lastName} <br>
		Country: ${student.country} <br>
		Favorite language: ${student.favoriteLanguage} <br>
		Operating systems:
		<ul>
			<c:forEach var="temp" items="${student.operatingSystems}">
			<li>${temp}</li>
			</c:forEach>
		</ul>
	</body>
</html>