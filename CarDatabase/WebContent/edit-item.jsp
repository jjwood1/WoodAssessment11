<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function validate(){
		var valName = document.forms["formOne"]["name"].value;
		var valYear = document.forms["formOne"]["year"].value;
		if(valName == "")
			{
				alert("Name is empty");
				return false;
			}
		if(valYear == "")
			{
				alert("Year is empty");
				return false;
			}
	}
</script>
</head>
<body>
	<form name="formOne" onsubmit="return validate()" action = "editCarServlet" method="post">
		Name: <input type ="text" name="name" value="${carToEdit.name}">
		Year: <input type="text" name="year" value="${carToEdit.year}">
		<input type ="hidden" name ="id" value="${carToEdit.id}">
		<input type = "submit" value="Save Edited Item">
	</form>
</body>
</html>