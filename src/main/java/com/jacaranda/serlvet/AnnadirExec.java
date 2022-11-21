package com.jacaranda.serlvet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jacaranda.crud.CRUDProducto;
import com.jacaranda.crud.Utilities;
//import com.jacaranda.crud.Utilities;
import com.jacaranda.model.Producto;

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
		response.sendRedirect("errorPage.jsp?error=entrado por get");
		
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
				+ "    <title>Annadiendo...</title>\n"
				+ "</head>\n"
				+ "<body>");

		boolean error=false;
		int noValid=0;
		int id=0;
		float precio=0;
		int categoria=0;
		int stock = 0;
		String redirect=null;
		
		
		String idString=request.getParameter("id");

		if(idString==null || idString.isEmpty()) { 
			error=true;
			noValid=8;

		}
		
		else if(!Utilities.isNumeric(idString)) { 
			error=true;
			noValid=2;
			
		}
		
		if(!error) {
			id=Integer.parseInt(idString);
			Producto pr = CRUDProducto.readProducto(id);
			if(pr != null ) {
				error=true;
				noValid=1;
			}
		}
		
		
		String nombre=request.getParameter("nombre");
		if(nombre== null || nombre.isEmpty()) { 
			error=true;
			noValid=3;
		
		}
		String precioString=request.getParameter("precio");	
		
		if(precioString== null || precioString.isEmpty()) {
			error=true;
			noValid=5;
			}
		
		else if(!Utilities.isFloat(precioString)) { 
			error=true;
			noValid=4;
		}

		 
		
	
		String descripcion=request.getParameter("descripcion");
		if(descripcion== null || descripcion.isEmpty()) { 
			error=true;
			noValid=6;
		
		}
		
		String stockString = request.getParameter("stock");
		if(stockString == null || stockString.isEmpty()) {
			stockString = "0";
		}
		else if(!Utilities.isNumeric(stockString) || Integer.parseInt(stockString)<0) {
			error=true;
			noValid=9;
		}
				
		String categoriaString=request.getParameter("categoria");
		
		if(categoriaString== null || categoriaString.isEmpty()) { 
			error=true;
			noValid=7;
		
		}
		if(!error) {
			
			precio=Float.parseFloat(precioString);
			categoria=Integer.parseInt(categoriaString);
			stock=Integer.parseInt(stockString);
			
			
		}
		
		if(error) {
			 redirect="annadirProducto.jsp?noValido="+noValid;
		}
		else {
			Producto p=new Producto(id,nombre,descripcion,precio, categoria, stock);
			CRUDProducto.addProducto(p);
			 
			 redirect="Main";
 
		}
		response.sendRedirect(redirect);
		response.getWriter().append("</body>");
			 
		
   			


	}

}
