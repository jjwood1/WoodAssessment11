<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a sold car here!</title>
<script type="text/javascript">
	function validate(){
		var valName = document.forms["formOne"]["owner"].value;
		if(valName == "")
			{
				alert("Owner is empty");
				return false;
			}
	}
</script>
</head>
<body>
		
		<tr>
		   <td>${soldCarToAdd.name}</td>
		   <td>${soldCarToAdd.year}</td>
		</tr><br />
		<form name="formOne" action = "sellCarServlet" onsubmit="return validate()" method = post>

		Customers Name: <input type = "text" name="owner">
		<input type ="hidden" name ="id" value="${soldCarToAdd.id}">
		<input type ="hidden" name ="name" value="${soldCarToAdd.name}">
		<input type ="hidden" name ="year" value="${soldCarToAdd.year}">
		<input type = "submit" value="Sell Car">
		</form>
</body>
</html>