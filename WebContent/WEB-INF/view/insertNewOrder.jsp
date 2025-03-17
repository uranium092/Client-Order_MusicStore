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
<h1>Agregar Pedido</h1> <br><br>
	<form:form action="saveOrder" method="post" modelAttribute="formMapping" id="form">
		<br>
		
		<form:hidden path="idCliente" value="${key}" />
		
		Artículo: <form:input path="articulo"/> <form:errors path="articulo" cssClass="error"></form:errors><br><br><br>
		
		Precio: <form:input path="precio"/> <form:errors path="precio" cssClass="error"></form:errors><br><br><br>
		
		<input type="submit" value="Agregar">
		
		
	</form:form>

</body>
</html>