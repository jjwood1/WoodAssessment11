<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sold Car List</title>
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
	<form method = "post" onsubmit="return validate()" action = "navigationForSoldCarsServlet">
	<table>
	<c:forEach items="${requestScope.allSoldCars}" var="currentsoldcar">
	<tr>
		<td><input type="radio" name="id" value="${currentsoldcar.id}">
		<td>${currentsoldcar.name}</td>
		<td>${currentsoldcar.year}</td>
		<td>${currentsoldcar.customer.customerName}</td>
		<td>${currentsoldcar.dateSold}</td>
	</tr>
	</c:forEach>
	
	</table>
	<input type = "submit" value = "Edit" name="doThisToItem">
	<input type = "submit" value = "Delete" name="doThisToItem"> <br />
	<a href = "index.html"> Return to list </a>
	</form>
</body>
</html>