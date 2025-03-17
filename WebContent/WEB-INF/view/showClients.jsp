<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="hibernate.*" %>
<%@ page import="java.util.*" %>
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
#newClient{
	font-size:1.1em;
	display:block;
}

table{
	background-color:#BBBBBB;
	display:block;
	width:75%;
	font-size:1.1em;
}

table tr{
	text-align:center;
}

table td{
	width:500px;
}
table th{
width:500px;
}

</style>
<body>

<%
   CRUD connectionDB=new CRUD();
   connectionDB.startSession();
   List<Cliente> allClients=connectionDB.getAllClients();
%>

<h1>CLIENTES</h1> <br>

<a href="formInsertClient" id="newClient">Nuevo Cliente</a> <br>

<table border="1px">
	<tr>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>Banda</th>
		<th>ACCIÓN</th>
	</tr>
	
	<%for(Cliente cl:allClients){ %>
	
		<tr>
			<td><%=cl.getNombreCliente() %></td>
			<td><%=cl.getApellidoCliente() %></td>
			<td><%=cl.getBandaCliente() %></td>
			<td>
				<a href="formUpdateClient?key=<%=cl.getId() %>">Actualizar</a>&nbsp;
				<a href="delC?key=<%=cl.getId() %>">Eliminar</a>&nbsp;
				<a href="showPedidos?key=<%=cl.getId() %>">Ver pedidos</a>
			</td>
		</tr>
	
	<%}; %>

</table>

</body>
</html>