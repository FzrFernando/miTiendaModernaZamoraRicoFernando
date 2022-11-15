package com.jacaranda.serlvet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jacaranda.crud.CRUDUsers;
import com.jacaranda.crud.Utilities;
import com.jacaranda.model.Users;

/**
 * Servlet implementation class RegisterExec
 */
@WebServlet("/RegisterExec")
public class RegisterExec extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterExec() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("errorPage.html");//poner con mensaje de error 404, o borrar el get directamente
		//El rollback tiene que ir en el catch
		//OPara las session, tendremos que hacer httpSession = request.getSession()
		//Ahora preguntamos por el getSession() o hacemos el setSession(login, password)
		
		//Pondemos poner un contador 
   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
		boolean existe=false;
		String link = "index.jsp";
		String usuarioCadena= request.getParameter("username");
		for (int i = 0; i < usuarioCadena.length(); i++) {
            if (usuarioCadena.charAt(i) == ' ') 
            	response.sendRedirect("errorPage.html");
        }

		
		
		Users u = CRUDUsers.readUser(usuarioCadena);
		if (u != null){
				existe=true;
			}
		
  
   		
   		if (existe==false){//comprobar que entren datos
   			String password= request.getParameter("password");
   			String nombreCompleto = request.getParameter("nombre_apellido");
   			LocalDateTime date = LocalDateTime.of(LocalDate.parse(request.getParameter("fecha_nacimiento")), LocalTime.now());
   			boolean sex = Boolean.parseBoolean(request.getParameter("sex"));
  			Users newU = new Users(usuarioCadena,Utilities.getMD5(password),nombreCompleto,date,sex,false);
  			CRUDUsers.addUser(newU);
  			
//  			HttpSession sesion=request.getSession();
//			sesion.setAttribute("login", "True");
//			sesion.setAttribute("usuario", usuarioCadena);
			response.sendRedirect(link);
//			response.getWriter().append("correcto");
//			response.getWriter().append("<a href='index.html'");

			

	
	}
   		else
   			response.sendRedirect("errorPage.html");
		
	}


	
}
