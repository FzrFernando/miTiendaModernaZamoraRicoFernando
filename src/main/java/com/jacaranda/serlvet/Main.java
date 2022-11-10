package com.jacaranda.serlvet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.crud.CRUDProducto;
import com.jacaranda.crud.CRUDUsers;
import com.jacaranda.producto.Producto;
import com.jacaranda.users.Users;

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

	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("errorPage.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <link rel=\"stylesheet\" href=\"style.css\">\n"
				+ "    <title>Document</title>\n"
				+ "</head>\n"
				+ "<body>"
				+ "<header id=\"main-header\">\n"
				+ "<n"
				+ "String bienvenida=\"\";\n"
				+ "HttpSession sesion=request.getSession();\n"
				+ "String isSesion = (String) sesion.getAttribute(\"login\");\n"
				+ "String userSesion= (String) sesion.getAttribute(\"usuario\");\n"
				+ "if(isSesion != null && userSesion!=null && isSesion.equals(\"True\")){\n"
				+ "	bienvenida=(\"Sesion: \"+userSesion);\n"
				+ "}\n"
				+ "else{\n"
				+ "<jsp:forward page=\"errorPage.html\"></jsp:forward>"
				+ "\n"
				+ "		<a id=\"logo-header\" href=\"index.jsp\"><img src=\"Images/logor.png\"></a>\n"
				+ "		<a id=\"title\" href=\"index.jsp\">CarBuy</a>\n"
				+ "\n"
				+ "		<nav>\n"
				+ "			<ul>\n"
				+ "\n"
				+ "				<li style=\"border-bottom: 2px solid #f0f2f1;\"><a\n"
				+ "					href=\"index.jsp\">Productos</a></li>\n"
				+ "			</ul>\n"
				+ "		</nav>\n"
				+ "\n"
				+ "	</header>\n"
				+ "	<div id=\"cuerpo\">");
		
		boolean existe=false;

		String usuarioCadena= request.getParameter("usuario");
		String password= request.getParameter("password");
		boolean usuarioAdmin= false;
		
   		List<Users>listaUsuarios=CRUDUsers.loadList();
   		for(Users u: listaUsuarios){
   			if (usuarioCadena.equals(u.getUsuario()) && getMD5(password).equals(u.getPassword())){
   				existe=true;
   	  			HttpSession sesion=request.getSession();
   				sesion.setAttribute("login", "True");
   				sesion.setAttribute("usuario", usuarioCadena);
   				usuarioAdmin=u.isAdministrador();
   			}
   			
   		}
   		
   		if (existe==true){//compronar que entren datos
   			if(usuarioAdmin) {
   				response.getWriter().append(
   						"<a href='annadirProducto'><button class='btReg'>A&ntildeadir Producto</button></a>"
   						);
   			}
   			List<Producto> listaProducto = CRUDProducto.loadList();
   			response.getWriter().append("<table border=\"1\" class'tabla'>"
   					+ "				<tr>"
   					+ "				<td class='tdId'>ID</td>\n"
   					+ "            <td class='tdName'>Nombre</td>\n"
   					+ "            <td class='tdPrice'>Precio</td>\n"
   					+ "            <td class='tdDescription'>Descripcion</td>\n"
   					+ "            <td class='tdCategoria'>ID Categoria</td>"
   					+ "				</tr>");
   			for(Producto p : listaProducto) {
   				response.getWriter().append("<tr>");
   				response.getWriter().append("<td>" + p.getId() + "</td>");
   				response.getWriter().append("<td>" + p.getNombre() + "</td>");
   				response.getWriter().append("<td>" + p.getPrecio() + " $</td>");
   				response.getWriter().append("<td>" + p.getDescripcion() + "</td>");
   				response.getWriter().append("<td>" + p.getId_categoria()+ "</td>");
   				response.getWriter().append("</tr>");
   			}
   			response.getWriter().append("</table>"
   					+ "</div>");
   			response.getWriter().append("</body>");
   			

  			


//			response.getWriter().append("correcto");
//			response.getWriter().append("<a href='index.html'");
			

	
	}
   		else
   			response.sendRedirect("errorPage.html");
		

	}

}
