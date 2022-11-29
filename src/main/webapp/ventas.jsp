<%@page import="java.util.Comparator"%>
<%@page import="com.jacaranda.model.Venta"%>
<%@page import="com.jacaranda.crud.CRUDVenta"%>
<%@page import="com.jacaranda.model.Categoria"%>
<%@page import="com.jacaranda.crud.CRUDCategoria"%>
<%@page import="com.jacaranda.crud.CRUDProducto"%>
<%@page import="com.jacaranda.model.Producto"%>
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
<title>Ventas</title>
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
	if (u != null) {
		if (Utilities.getMD5(password).equals(u.getPassword())) {
			sesion.setAttribute("login", "True");
			sesion.setAttribute("usuario", usuarioCadena);
			sesion.setAttribute("password", password);
		} else {
			
			response.sendRedirect("errorPage.jsp?error=4");
		}
	}

	
	
	Carrito c = (Carrito) sesion.getAttribute("carrito");
	
	int contadorProductos=c.cantidadProductosTotales();
	
	
	
%>

	<header id="main-header">		
        <a id="title" href="Main">CAR</a>
        <a id="titleBlue" href="Main">Buy</a>
        <a id="logo-header" href="Main"><img src="Images/logor.png"></a>
        <nav>		
            <ul>
            	<li class='imgDollarIn tooltip';> 
                    <a href='#'> 
                        <img src="Images/dollar.svg" width="30px"> 
                    </a>
                </li> 
                <li class='imgCarro tooltip';> 
                    <a href='carrito.jsp'> 
                        <img src="Images/carro.svg" width="50px"> 
                        <span class='tooltiptext'><%= contadorProductos %></span>
                    </a>
                </li> 
                <li class='imgUser tooltip'>
                    <a href='index.jsp'> 
                        <img src="Images/user.svg" width="38.5px"> 
                        <span class="tooltiptext"><%=usuarioCadena%>
                        </span> 
                    </a>
                </li>		
            </ul>
        </nav>
    </header>	
	<div id="cuerpo">
        <h1 class="titulo">VENTAS</h1><br><br><br><br><br>
        <div class="fondoVenta">

<%
	List<Venta> listaVentas = CRUDVenta.loadList();
	if(listaVentas.size()>0){
		for(Venta v : listaVentas){

%>
            <div class="venta">
                <nav class="fechaVentas" style="float: left;">
                    <%= v.getFecha_venta() %>
                </nav>

                    <table border="1" class="tabla">
                        <tr>
                            <td class="letraTabla">
                                ID. producto
                            </td>
                            <td class="letraTabla">
                                Nombre Producto
                            </td>
                            <td class="letraTabla">
                                Cantidad
                            </td>
                            <td class="letraTabla">
                                Precio Unidad
                            </td>
                            <td class="letraTabla" >
                                Total Precio
                            </td>
                            
                        </tr>
                        <tr>
                            <td>
                                <%= v.getId_producto().getId_producto() %>
                            </td>
                            <td>
                                <%= v.getId_producto().getNombre() %>
                            </td>
                            <td>
                                <%= v.getCantidad() %>
                            </td>
                            <td>
                                <%= v.getPrecio() %>
                            </td>
                            <td>
                                <%= v.getPrecio()*v.getCantidad() %>
                            </td>
                            
                        </tr>
                        
                    </table>
            </div>
            <hr width="90%">
<% } }%>


            

            
        
        </div>
    </div>
</body>
</html>