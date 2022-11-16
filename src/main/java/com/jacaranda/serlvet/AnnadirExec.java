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
import com.jacaranda.model.Categoria;
import com.jacaranda.model.Producto;
import com.jacaranda.model.Users;

/**
 * Servlet implementation class AnnadirExec
 */
@WebServlet("/AnnadirExec")
public class AnnadirExec extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnadirExec() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("<!DOCTYPE html>\n"
				+ "<html lang=\"en\">\n"
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <link rel=\"stylesheet\" href=\"style.css\">\n"
				+ "    <title>Añadiendo...</title>\n"
				+ "</head>\n"
				+ "<body>");

		
		int id=Integer.parseInt(request.getParameter("id"));
		String nombre=request.getParameter("nombre");
		float precio=Float.parseFloat(request.getParameter("precio"));
		String descripcion=request.getParameter("descripcion");
		int categoria=Integer.parseInt(request.getParameter("categoria"));
		Boolean entrar=true;
		
		Producto pr = CRUDProducto.readProducto(id);
		
		if(pr != null) {
			entrar=false;
		}
		
		if(entrar==false){
			response.sendRedirect("annadirProducto.jsp?error=1");
		}
		else{			 
			 Producto p=new Producto(id,nombre,descripcion,precio, categoria);
			 CRUDProducto.addProducto(p);
			 
			 String redirect="Main";
			 response.sendRedirect(redirect);
		}

   			
   			response.getWriter().append("</body>");
   			

  			


//			response.getWriter().append("correcto");
//			response.getWriter().append("<a href='index.html'");
			

	
	}


}
