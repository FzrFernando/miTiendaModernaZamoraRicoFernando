<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="shortcut icon" href="Images/logor.png"> 
</head>
<body>
<%String error=request.getParameter("error");
String mensaje=null;
String redirect=null;
if (error!=null){
	
	switch (error){
	case "1":
		redirect="index.jsp";
		mensaje="Nombre de usuario o contraseña no valida";
		break;
	case "2":
		mensaje="Método GET o no se han introducido parámetros";
		redirect="index.jsp";
		break;
	case "3":
		mensaje="El usuario no existe";
		redirect="index.jsp";
		break;
	case "4":
		mensaje="La contraseña no es válida";
		redirect="index.jsp";
		break;
	}
}
%>

	<header id="main-header">

		<a id="title" href="index.jsp">CAR</a>
		<a id="titleBlue" href="index.jsp">Buy</a>
		<a id="logo-header" href="index.jsp"><img src="Images/logor.png"></a>

		<nav>
			<ul>

				<li style="border-bottom: 2px solid #f0f2f1;"><a>Error</a></li>
			</ul>
		</nav>

	</header>
<div id="cuerpo">

			
			<div class="fondoError">
			<br>
			<p id="bold">¡¡FATAL ERROR!!</p>
				<%= mensaje %>
			<br><br><br>	
				<a href="index.jsp"><button class="botonError">Volver</button></a>
			</div>


		
	</div>


</body>
</html>