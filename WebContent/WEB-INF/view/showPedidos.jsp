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
	background-color:#A8A8A;
}
#datosCliente{

		display: grid;
        grid-template-columns: repeat(2, 1fr);
        justify-items: center;
        width:60%;
        background-color:#BBBBBB;
        border-radius:12px;
        border:3px solid black;
        margin:auto;

}
h2{
	background-color:#979797;
	padding:0px 30px;
}
.title{
	color:#454242;
	background-color:transparent;
	padding:0;
}

table{
	background-color:#BBBBBB;
	display:block;
	width:50%;
	font-size:1.1em;
	margin:auto;
}

table tr{
	text-align:center;
}

table td, table th{
	width:500px;
}

a{
display:block;
text-align:center;
font-size:1.15em;
}
</style>
<%
	Cliente client=(Cliente)request.getAttribute("key");
	List<Pedido>pedidos=client.getPedido();

%>
<body>
<h1>Pedidos de:</h1> <br>
<section id="datosCliente">
<h2 class="title">Nombre:</h2>
<h2>${key.nombreCliente}</h2>
<h2 class="title">Apellido:</h2>
<h2>${key.apellidoCliente}</h2>
<h2 class="title">Banda:</h2>
<h2>${key.bandaCliente}</h2>
</section> <br> <br>

<table border="1px">
<a href="formInsertOrders?key=${key.idCliente}">Nuevo Pedido</a> <br>
	<tr>
		<th>Artículo</th>
		<th>Precio</th>
		<th>ACCIÓN</th>
	</tr>
	<%for(Pedido ped:pedidos){ %>
	
		<tr>
			<td><%=ped.getArticuloCliente() %></td>
			<td><%=ped.getPrecioArticulo() %></td>
			<td>
				<a href="formUpdateOrder?key=<%=ped.getIdPedido()%>">Actualizar</a>&nbsp;
				<a href="del?key=<%=ped.getIdPedido()%>">Eliminar</a>&nbsp;
			</td>
		</tr>
	
	<%}; %>
</table>

</body>
</html>