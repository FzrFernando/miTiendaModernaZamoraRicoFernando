<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<main>
<header id="main-header">

		<a id="title" href="index.jsp">CAR</a>
		<a id="titleBlue" href="index.jsp">Buy</a>
		<a id="logo-header" href="index.jsp"><img src="Images/logor.png"></a>

		<nav>
			<ul>
			</ul>
		</nav>
</header>
<div id="cuerpo">
        <form action="RegisterExec" method="post" id="form">
        	<div class="registerBorder">
        		<br>
	            <h1>
	                Registrarse
	            </h1>
	            <div class="introducir">
	                <label for="Username">
	                    Usuario
	                </label> 
	                <br>
	                <input type="text" name="username" id="username" placeholder="Username" class="registerInput">
	                <p><%int error=Integer.parseInt(request.getParameter("noValido")); %>
							<% if (error==1){
							%><small style=color:red;>Este usuario ya existe</small><br><%
							}else if(error==2){
							%><small style=color:red;>El usuario no puede tener espacios</small><br>
							<%}else if(error==3){
							%><small style=color:red;>El usuario es nulo</small><br>
							<%}%></p>
	            </div>
	
	            <div class="introducir">
	                <label for="Full Name">
	                    Nombre Completo
	                </label><br>
	                <input type="text" name="nombre_apellido" id="nombre_apellido" placeholder="Full Name" autocomplete="off" class="registerInput">
	                <p><% if (error==5){
							%><small style=color:red;>Este nombre es nula</small><br><%
							}%></p>
	            </div>
	            
	            <div class="introducir">
	                <label for="Fecha Nacimiento">
	                    Fecha Nacimiento
	                </label><br>
	                <input type="date" name="fecha_nacimiento" id="fecha_nacimiento" placeholder="fecha Nacimiento Name" autocomplete="off" class="registerInput">
	                <p><% if (error==6){
							%><small style=color:red;>Esta fecha es nula</small><br><%
							}%></p>
	            </div>
	
	            <div class="introducir">
	                <label for="Sex">
	                    Género
	                </label><br>
	                Masculino:
	                <input type="radio" name="sex" id="male" class="register" checked>
	                Femenino:
	                <input type="radio" name="sex" id="female" class="register"> 
	                <p><% if (error==7){
							%><small style=color:red;>El sexo es nulo</small><br><%
							}%></p>
	            </div>
	
	            <div class="introducir">
	                <label for="Password">
	                    Password
	                </label><br>
	                <input type="password" name="password" id="password" placeholder="Password" autocomplete="off" class="registerInput">
	                <p><% if (error==4){
							%><small style=color:red;>Este nombre es nula</small><br><%
							}%></p>
	            </div>
	
	            <button type="submit" class="registerButton">Registrarse</button>
	            <br><br>
	            <a href="index.jsp"><button type="button" class="join">Volver</button></a>
	          </div>

        </form>
</div>
    </main>

</body>
</html>