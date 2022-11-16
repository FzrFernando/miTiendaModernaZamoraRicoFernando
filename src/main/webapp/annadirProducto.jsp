<%@page import="java.util.List"%>
<%@page import="com.jacaranda.crud.CRUDCategoria"%>
<%@page import="com.jacaranda.model.Categoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Añadir Producto</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<%
String bienvenida="";
HttpSession sesion=request.getSession();
String isSesion = (String) sesion.getAttribute("login");
String userSesion= (String) sesion.getAttribute("usuario");
if(isSesion != null && userSesion!=null && isSesion.equals("True")){
	bienvenida=("Sesion: "+userSesion);
}
else{
%> <jsp:forward page="errorPage.jsp?error=3"></jsp:forward> <%
}
%>
	<main>
		<header id="main-header">

			<a id="title" href="index.jsp">CAR</a> <a id="titleBlue"
				href="index.jsp">Buy</a> <a id="logo-header" href="index.jsp"><img
				src="Images/logor.png"></a>

			<nav>
				<ul>

					<li style="border-bottom: 2px solid #f0f2f1;"><a
						href="index.jsp">Añadir Producto</a></li>
					<li><a
						href="index.jsp"><%=bienvenida %></a></li>
				</ul>
			</nav>
		</header>
		<div id="cuerpo">
			<form action="AnnadirExec" method="post" id="form">
				<div class="registerBorder">
					<br>
					<h1>Añadir Producto</h1>
					<div class="introducir">
						<label for="Id"> Id </label> <br> <input type="text"
							name="id" id="username" placeholder="Id" class="registerInput"
							required>
						<p>
							<small id="warnings"></small>
						</p>
					</div>

					<div class="introducir">
						<label for="Nombre"> Nombre </label><br> <input type="text"
							name="nombre" id="nombre_apellido" placeholder="Nombre"
							autocomplete="off" class="registerInput" required>
						<p>
							<small id="warnings"></small>
						</p>
					</div>

					<div class="introducir">
						<label for="Precio"> Precio </label><br> <input type="number"
							name="precio" id="fecha_nacimiento" placeholder="Precio"
							autocomplete="off" class="registerInput" required>
						<p>
							<small id="warnings"></small>
						</p>
					</div>

					<div class="introducir">
						<label for="Descripcion"> Descripcion </label><br> <input
							type="text" name="descripcion" id="password"
							placeholder="Descripcion" autocomplete="off"
							class="registerInput" required>
						<p>
							<small id="warnings"></small>
						</p>
					</div>

					<div class="introducir">
						<label for="Categoria"> Categoria </label><br> 
						<select
							class="registerInput" name="categoria">
							<%
							List<Categoria> lista = CRUDCategoria.loadList();
							for (Categoria c : lista) {
							%>
							<option name="<%=c.getId_categoria()%>" value="<%=c.getId_categoria()%>"><%=c.getNombre()%></option>
							<%
							}
							%>
						</select>
						<p>
							<small id="warnings"></small>
						</p>
					</div>

					<button type="submit" class="registerButton">Añadir</button>
					<br>
					<br> <a href="Main"><button type="button" class="join">Volver</button></a>
				</div>

			</form>
		</div>
	</main>

</body>
</html>