package com.jacaranda.serlvet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jacaranda.crud.CRUDUsers;
import com.jacaranda.users.Users;

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
		
   		List<Users>listaUsuarios=CRUDUsers.loadList();
   		for(Users u: listaUsuarios){
   			if (usuarioCadena.equals(u.getUsuario())){
   				existe=true;
   			}
   			
   		}
   		
   		if (existe==false){//compronar que entren datos
   			String password= request.getParameter("password");
   			String nombreCompleto = request.getParameter("nombre_apellido");
   			LocalDate date = LocalDate.parse(request.getParameter("fecha_nacimiento"));
   		 	LocalDate newDate =LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth()+1); 
   			boolean sex = Boolean.parseBoolean(request.getParameter("sex"));
  			Users newU = new Users(usuarioCadena,getMD5(password),nombreCompleto,date,sex,false);
  			CRUDUsers.addUser(newU);
  			
  			HttpSession sesion=request.getSession();
			sesion.setAttribute("login", "True");
			sesion.setAttribute("usuario", usuarioCadena);
			response.sendRedirect(link);
//			response.getWriter().append("correcto");
//			response.getWriter().append("<a href='index.html'");

			

	
	}
   		else
   			response.sendRedirect("errorPage.html");
		
	}


	
}
