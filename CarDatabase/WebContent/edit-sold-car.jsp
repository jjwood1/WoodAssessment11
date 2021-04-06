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
		var valOwner = document.forms["formOne"]["owner"].value;
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
		if(valOwner == "")
			{
			alert("Owner is empty");
			return false;
			}
	}
</script>
</head>
<body>
	<form name="formOne" action = "editSoldCarServlet" onsubmit="return validate()" method="post">
	Name: <input type ="text" name="name" value="${soldCarToEdit.name}">
	Year: <input type ="text" name="year" value="${soldCarToEdit.year}">
	Owner: <input type ="text" name="owner" value="${soldCarToEdit.customer.customerName}">
	<input type ="hidden" name="id" value="${soldCarToEdit.id}">
	<input type = "submit" value="Save Edited Sold Car">
	</form>
</body>
</html>