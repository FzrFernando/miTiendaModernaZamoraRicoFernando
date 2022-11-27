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
int productosEnCarrito = 0;
/* boolean carritoExiste= true; */
if(u!=null) {
	if(Utilities.getMD5(password).equals(u.getPassword())) {
		sesion.setAttribute("login", "True");
		sesion.setAttribute("usuario", usuarioCadena);
		sesion.setAttribute("password", password);
	}else {
		redirect="errorPage.jsp?error=4";
	}
}
	
Carrito c=(Carrito) sesion.getAttribute("carrito");


int id_articulo=Integer.parseInt(request.getParameter("id_articulo"));
int cantidad=Integer.parseInt(request.getParameter("cantidad"));
float precio=Float.parseFloat(request.getParameter("precio"));
productosEnCarrito+= cantidad;

ItemCarrito i = new ItemCarrito(id_articulo, cantidad, precio,date);


if(c==null){
	c= new Carrito();
	sesion.setAttribute("carrito", c);
}

else{
	List<ItemCarrito> l = c.getCarrito();
	if(l!=null){
		int indice =l.indexOf(i);
		ItemCarrito oldItem = l.get(indice); 
		i.setCantidad(cantidad+oldItem.getCantidad());
		for(ItemCarrito item : l){
			productosEnCarrito+= item.getCantidad();
		}
	}
} 


			
%>
	<header id="main-header">
		<a id="title" href="Main">CAR</a>
		<a id="titleBlue" href="Main">Buy</a>
		<a id="logo-header" href="Main"><img src="Images/logor.png"></a> 
		<nav>
			<ul>
				<li class='imgCarro tooltip'> 
					<a href='CarritoCompra'> 
						<img src="Images/carro.svg"> 
						<span class='tooltiptext'><%= productosEnCarrito %>
						</span>
					</a>
				</li>  
				<li class='imgUser tooltip'>
					<a href='index.jsp'> 
						<img src="Images/user.svg"> 
						<span class="tooltiptext"><%= usuarioCadena %>
						</span> 
					</a>
				</li>
			</ul>
		</nav>
	</header>
</body>
</html>