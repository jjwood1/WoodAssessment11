<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car List</title>
<script type="text/javascript">
	function validate(){
		var radios = document.getElementsByName("id");
		var myValid = false;
		var i = 0;
		while(!myValid && i < radios.length){
			if(radios[i].checked){
				myValid = true;
				}
			i++;
			}
		if(!myValid)
			{
				alert("Forgot to select car!");
			}
		return myValid;
			}
</script>	
</head>
<body>
	<form name="Form1" action = "navigationServlet" onsubmit="return validate()" method = "post">
	<table>
	<c:forEach items="${requestScope.allCars}" var="currentcar">
	<tr>
		<td><input type="radio" name="id" value="${currentcar.id}"></td>
		<td>${currentcar.name}</td>
		<td>${currentcar.year}</td>
		</tr>
	</c:forEach>
	</table>
	<input type = "submit" value = "edit" name="doThisToItem">
	<input type = "submit" value = "delete" name="doThisToItem">
	<input type = "submit" value = "sell" name="doThisToItem">
	<a href = "index.html"> add </a>
	</form>
</body>
</html>