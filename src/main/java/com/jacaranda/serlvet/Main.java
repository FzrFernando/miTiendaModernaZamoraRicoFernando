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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
				+ "<body>");
		
		boolean existe=false;

		String usuarioCadena= request.getParameter("usuario");
		String password= request.getParameter("password");
		
   		List<Users>listaUsuarios=CRUDUsers.loadList();
   		for(Users u: listaUsuarios){
   			if (usuarioCadena.equals(u.getUsuario()) && getMD5(password).equals(u.getPassword())){
   				existe=true;
//   	  			HttpSession sesion=request.getSession();
//   				sesion.setAttribute("login", "True");
//   				sesion.setAttribute("usuario", usuarioCadena);
   			}
   			
   		}
   		
   		if (existe==true){//compronar que entren datos
   			List<Producto> listaProducto = CRUDProducto.loadList();
   			response.getWriter().append("<table border=\"1\">"
   					+ "				<tr>"
   					+ "				<td>ID</td>\n"
   					+ "            <td>Nombre</td>\n"
   					+ "            <td>Precio</td>\n"
   					+ "            <td>Descripcion</td>\n"
   					+ "            <td>ID Categoria</td>"
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
   			response.getWriter().append("</table>");
   			response.getWriter().append("</body>");
   			

  			


//			response.getWriter().append("correcto");
//			response.getWriter().append("<a href='index.html'");
			

	
	}
   		else
   			response.sendRedirect("errorPage.html");
		

	}

}
