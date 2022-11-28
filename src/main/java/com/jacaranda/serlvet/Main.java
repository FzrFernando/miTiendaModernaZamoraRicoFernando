package com.jacaranda.serlvet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.crud.CRUDCategoria;
import com.jacaranda.crud.CRUDProducto;
import com.jacaranda.crud.CRUDUsers;
import com.jacaranda.crud.Utilities;
import com.jacaranda.model.Carrito;
import com.jacaranda.model.Categoria;
import com.jacaranda.model.Producto;
import com.jacaranda.model.Users;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Main() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean entrar = false;
		boolean salir=false;
		boolean usuarioAdmin=false;
		String redirect = null;
		int contadorProductos=0;
		Carrito ca = null;
		HttpSession sesion = null;
		
		String usuarioCadena = request.getParameter("usuario");
		String password = request.getParameter("password");
		if(usuarioCadena!=null && password!=null) {
			sesion = request.getSession();
			Users u = CRUDUsers.readUser(usuarioCadena);
			u = CRUDUsers.readUser(usuarioCadena);
			if(u!=null) {
				
				if(Utilities.getMD5(password).equals(u.getPassword())) {
					entrar= true;
					sesion.setAttribute("login", "True");
					sesion.setAttribute("usuario", usuarioCadena);
					sesion.setAttribute("password", password);
					usuarioAdmin = u.isAdministrador();		
					
				}else {
					salir=true;
					redirect="errorPage.jsp?error=4";
				
				}
			}else {
				salir=true;
				redirect="errorPage.jsp?error=3";
			}
		}
		if(!entrar) {
			sesion = request.getSession();
			usuarioCadena = (String) sesion.getAttribute("usuario");
			password = (String) sesion.getAttribute("password");
			Users u = CRUDUsers.readUser(usuarioCadena);
			if(u!=null) {
				if(Utilities.getMD5(password).equals(u.getPassword())) {
					entrar= true;
					sesion.setAttribute("login", "True");
					sesion.setAttribute("usuario", usuarioCadena);
					sesion.setAttribute("password", password);
					usuarioAdmin = u.isAdministrador();
				}else {
					salir=true;
					redirect="errorPage.jsp?error=4";
				}
			}	
		}
		
		
		if(entrar) {
			ca= (Carrito) sesion.getAttribute("carrito");
			if(ca!=null) {
				contadorProductos=ca.cantidadProductos();
			}
			
			
		
		String bienvenida = (usuarioCadena);
		

		response.getWriter().append("<!DOCTYPE html>\n" 
				+ "<html lang=\"en\">\n" 
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n" 
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <link rel=\"stylesheet\" href=\"style.css\">\n" 
				+ "    <title>Document</title>\n"
				+ "	   <link rel=\"shortcut icon\" href=\"Images/logor.png\"> " 
				+ "</head>\n"
				+ "<body>" 
				+ "<header id=\"main-header\">\n" 
				+ "		<a id=\"title\" href=\"Main\">CAR</a>\n"
				+ "		<a id=\"titleBlue\" href=\"Main\">Buy</a>\n"
				+ "		<a id=\"logo-header\" href=\"Main\"><img src=\"Images/logor.png\"></a>" 
				+ "\n"
				+ "		<nav>\n" 
				+ "			<ul>\n" 
				+ "\n"
				+ " <li class='imgCarro tooltip'> <a href='CarritoCompra'> <img src=\"Images/carro.svg\"> <span class='tooltiptext'>"+ contadorProductos +"</span></a></li>  "
				+ "<li class='imgUser tooltip'><a href='index.jsp'> <img src=\"Images/user.svg\"> <span class=\"tooltiptext\">"+ bienvenida + "</span> </a></li></ul>\n"
				+ "		</nav>\n" 
				+ "\n" 
				+ "	</header>\n" );


				if (usuarioAdmin) {
					response.getWriter().append("<br>"
							+ "<a href='annadirProducto.jsp?noValido=0'><button class='registerButton' id='bold'>A&ntildeadir Producto</button></a> <br>");
				}
				
			

			List<Producto> listaProducto = CRUDProducto.loadList();

//			response.getWriter()
//					.append("<table border=\"1\" class='tabla'>" + "				<tr>"
//							+ "				<td class='tdId' id='bold'>ID</td>\n"
//							+ "            <td class='tdName' id='bold'>Nombre</td>\n"
//							+ "            <td class='tdPrice' id='bold'>Precio</td>\n"
//							+ "            <td class='tdDescription' id='bold'>Descripcion</td>\n"
//							+ "            <td class='tdCategoria' id='bold'>Categoria</td>"
//							+ "			   <td class='tdStock' id='bold'>Stock</td>" + "				</tr>");
			
			response.getWriter().append(" <br> <div class=grid-container>");
			for (Producto p : listaProducto) {
				Categoria c = CRUDCategoria.readCategoria(p.getId_categoria());
				
				
				
				response.getWriter().append(" <div class=\"card\">\n"
									+ "            <div class=\"photo\">\n"
									+ "                 <img class='foto' src=\"Images/Ford3.png\">\n"
									+ "            </div>\n"
									+ "            <div class=\"description\">\n"
									+ "                <a class=\"titulitos\">"+ p.getNombre() +"</a> "
									+ "				   <small>"+c.getNombre()+" </small> <br>\n"
									+                  p.getPrecio() + "$<br>\n"
									+ "                <a class=\"descripcion\">" + p.getDescripcion() +"</a>  <br>\n"
									+ "                <hr>\n"
									+ "					<form action='annadirAlCarro.jsp' method='post' id='form'>"
									+ "				   		<Input type=\"number\" value='1' class='inputAnnadirCarro' name='cantidad' max="+ p.getStock() +">"
									+ "				   		<Input type=\"text\" name='id_articulo' value="+ p.getId() +" hidden>"
									+ "				   		<Input type=\"text\" name='precio' value="+ p.getPrecio() +" hidden>"
									+ "						<Input type='number' name='contadorProductos' value='"+ contadorProductos + "' hidden>"
									+ "				   		<button type=\"submit\" class=\"buttonAnnadirCarro\">A&ntildeadir al carro</button> <br>"
									+ "				   		Stock : "+ p.getStock()+ "<br>\n"
									+ "					</form>"
									+ "            </div> \n"
									+ "        </div> ");
				
//				response.getWriter().append("<tr>");
//				response.getWriter().append("<td>" + p.getId() + "</td>");
//				response.getWriter().append("<td>" + p.getNombre() + "</td>");
//				response.getWriter().append("<td>" + p.getPrecio() + " $</td>");
//				response.getWriter().append("<td>" + p.getDescripcion() + "</td>");			
//				response.getWriter().append("<td>" + c.getNombre() + "</td>");
//				response.getWriter().append("<td>" + p.getStock() + "</td>");
//				response.getWriter().append("</tr>");
			}
			response.getWriter().append("</div>");
			response.getWriter().append("</div>");
			response.getWriter().append("</body>");
			response.getWriter().append("</html>");


		}
		else {
			if(!salir && !entrar) {
				redirect="errorPage.jsp?error=2";
			}

			response.sendRedirect(redirect);
		}
		
			

	}

}
