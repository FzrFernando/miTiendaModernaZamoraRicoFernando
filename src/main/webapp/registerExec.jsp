<%@page import="java.time.LocalDate"%>
<%@page import="com.jacaranda.users.Users"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:useBean id="usuario" class="com.jacaranda.users.Users"></jsp:useBean> 
<jsp:useBean id="usuarioBD" class="com.jacaranda.crud.CRUDUsers"></jsp:useBean>  
</head>
<body>


<!-- //CREATE TABLE USUARIO(
//		USUARIO VARCHAR(50) UNIQUE,
//		PASSWORD VARCHAR(50),
//		NOMBRE_APELLIDO VARCHAR(75),
//		FECHA_NACIMIENTO DATE,
//		GENERO BOOLEAN,
//		ADMINISTRADOR BOOLEAN,
//		CONSTRAINT PK_USUARIO PRIMARY KEY(USUARIO)
//		); -->
<%


	

		boolean existe=false;
		String usuarioCadena= request.getParameter("usuario");
		
   		
   		List<Users>listaUsuarios=usuarioBD.loadList();
   		for(Users u: listaUsuarios){
   			if (usuarioCadena.equals(u.getUsuario())){
   				existe=true;
   			}
   			
   		}
   		if (existe==false){
   			String password= request.getParameter("password");
   			String nombreCompleto = request.getParameter("nombre_apellido");
   			LocalDate date = LocalDate.parse(request.getParameter("fecha_nacimiento"));
   		 	LocalDate newDate =LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth()+1); 
   			boolean sex = Boolean.parseBoolean(request.getParameter("sex"));
  			Users newU = new Users(usuarioCadena,password,nombreCompleto,date,sex,false);

	
	} 
%>
</body>
</html>