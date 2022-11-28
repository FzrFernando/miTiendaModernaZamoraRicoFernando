<%@page import="java.util.List"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jacaranda.model.ItemCarrito"%>
<%@page import="com.jacaranda.crud.Utilities"%>
<%@page import="com.jacaranda.crud.CRUDUsers"%>
<%@page import="com.jacaranda.model.Users"%>
<%@page import="com.jacaranda.model.Carrito"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<link rel="shortcut icon" href="Images/logor.png">
</head>
<body>
	<%
	String redirect = "";
	HttpSession sesion = request.getSession();
	String usuarioCadena = (String) sesion.getAttribute("usuario");
	String password = (String) sesion.getAttribute("password");
	LocalDateTime date = LocalDateTime.now();
	Users u = CRUDUsers.readUser(usuarioCadena);
	/* boolean carritoExiste= true; */
	if (u != null) {
		if (Utilities.getMD5(password).equals(u.getPassword())) {
			sesion.setAttribute("login", "True");
			sesion.setAttribute("usuario", usuarioCadena);
			sesion.setAttribute("password", password);
		} else {
			redirect = "errorPage.jsp?error=4";
		}
	}

	Carrito c = (Carrito) sesion.getAttribute("carrito");

	int id_articulo = Integer.parseInt(request.getParameter("id_articulo"));
	int cantidad = Integer.parseInt(request.getParameter("cantidad"));
	float precio = Float.parseFloat(request.getParameter("precio"));
	int contadorProductos = Integer.parseInt(request.getParameter("contadorProductos"));
	contadorProductos += cantidad;

	ItemCarrito i = new ItemCarrito(id_articulo, cantidad, precio, date);

	if (c == null) {
		c = new Carrito();
		sesion.setAttribute("carrito", c);
	}

	else {
			c.updateItem(i, contadorProductos);
			contadorProductos = c.cantidadProductos();
			
		}
	%>
	<header id="main-header">
		<a id="title" href="Main">CAR</a> <a id="titleBlue" href="Main">Buy</a>
		<a id="logo-header" href="Main"><img src="Images/logor.png"></a>
		<nav>
			<ul>
				<li class='imgCarro tooltip'><a href='CarritoCompra'> <img
						src="Images/carro.svg"> <span class='tooltiptext'><%=contadorProductos%>
					</span>
				</a></li>
				<li class='imgUser tooltip'><a href='index.jsp'> <img
						src="Images/user.svg"> <span class="tooltiptext"><%=usuarioCadena%>
					</span>
				</a></li>
			</ul>
		</nav>
	</header>

	<div id="cuerpo">
		<div class="fondoCarrito">

			<div class="photo">
				<img src="Images/Ford3.png" class="photo_sure">
			</div>

			<div class="description">
				<a class="titulitos">Avenger</a> <small>Pontiac</small> <br>
				38.82 $<br> <a class="descripcion">Burn of unsp deg mult
					sites of right ankle and foot, subs</a> <br>
				<hr>

				<p class="colorAzul"><%= contadorProductos %> Artículos Añadidos</p>

				<div id="introducir">
					<a href="Main">
						<button class="join">
							<h2>Seguir comprando</h2>
						</button>
					</a>
				</div>
				<div id="registrarse">
					<a href="CarritoCompra">
						<button class="registerButton" type="button">
							<h2>Ir al carrito</h2>
						</button>
					</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>