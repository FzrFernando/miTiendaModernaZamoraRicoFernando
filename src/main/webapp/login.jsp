<%@page import="com.jacaranda.users.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean id="usuario" class="com.jacaranda.users.Users"></jsp:useBean> 
<jsp:useBean id="usuarioBD" class="com.jacaranda.crud.CRUDUsers"></jsp:useBean>  
<title>Logueando...</title>
</head>
<body>
<%
		String usuarioCadena= request.getParameter("usuario");
		String password= request.getParameter("password");
   		
   		List<Users>listaUsuarios=usuarioBD.loadList();
   		for(Users u: listaUsuarios){
   			if (usuarioCadena.equals(u.getUsuario())){
   				usuario=usuarioBD.readUser(usuarioCadena);
   			}
   		}

	if(password.equals(usuario.getPassword())){
		System.out.println("Si");
		HttpSession sesion=request.getSession();
		sesion.setAttribute("login", "True");
		sesion.setAttribute("usuario", usuarioCadena);
		String redirect="Main.java";
		 response.sendRedirect(redirect);
	}
	else{
		 response.sendRedirect("errorPage.html");
	} 
%>
</body>
</html>