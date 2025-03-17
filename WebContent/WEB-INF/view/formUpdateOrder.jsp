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
<h1>Actualizar Pedido =&nbsp; ${dataOrderView.articuloCliente}, ${dataOrderView.precioArticulo}$ </h1> <br><br>
<form:form action="updP" method="post" modelAttribute="formMapping" id="form">
<br>
<form:hidden path="idPedido" value="${dataOrderView.idPedido}"/>
Artículo: <form:input path="nombreArticulo" value="${dataOrder.articuloCliente}" /><form:errors path="nombreArticulo" cssClass="error"></form:errors><br><br><br>

Precio: <form:input path="precio" value="${dataOrder.precioArticulo}"/><form:errors path="precio" cssClass="error"></form:errors><br><br><br>

<input type="submit" value="Actualizar">

</form:form>
</body>
</html>