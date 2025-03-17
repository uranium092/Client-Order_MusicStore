<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
h1{
	text-align:center;
	background-color:gray;
	border-bottom: 4px solid black;
	padding:5px;
}
#form{
	background-color:#BBBBBB;
	margin:auto;
	text-align:center;
	border-radius:12px;
	border: 3px solid black;
	width:50%;
}

.error{
	color:red;
}

</style>
<body>

<h1>Agregar Cliente</h1> <br><br>

	<form:form action="saveClient" method="post" modelAttribute="formMapping" id="form">
		<br>
		Nombre: <form:input path="name"/> <form:errors path="name" cssClass="error"></form:errors><br><br><br>
		
		Apellido: <form:input path="lastName"/> <form:errors path="lastName" cssClass="error"></form:errors><br><br><br>
		
		Banda: <form:input path="band"/> <form:errors path="band" cssClass="error"></form:errors><br><br><br>
		
		<input type="submit" value="Agregar">
		
		
	</form:form>


</body>
</html>