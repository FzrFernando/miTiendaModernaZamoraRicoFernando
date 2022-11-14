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

		<a id="logo-header" href="index.jsp"><img src="Images/logor.png"></a>
		<a id="title" href="index.jsp">CarBuy</a>

		<nav>
			<ul>

				<li style="border-bottom: 2px solid #f0f2f1;"><a
					href="index.jsp">Log in</a></li>
			</ul>
		</nav>
</header>
<div id="cuerpo">
        <form action="RegisterExec" method="post" id="form">
            <h1>
                Registrarse
            </h1>
            <div class="form-field">
                <label for="Username">
                    Usuario
                </label> 
                <br>
                <input type="text" name="username" id="username" placeholder="Username" class="register" required>
                <p><small id="warnings"></small></p>
            </div>

            <div class="form-field">
                <label for="Full Name">
                    Nombre Completo
                </label><br>
                <input type="text" name="nombre_apellido" id="nombre_apellido" placeholder="Full Name" autocomplete="off" class="register" required>
                <p><small id="warnings"></small></p>
            </div>
            
            <div class="form-field">
                <label for="Fecha Nacimiento">
                    Fecha Nacimiento
                </label><br>
                <input type="date" name="fecha_nacimiento" id="fecha_nacimiento" placeholder="fecha Nacimiento Name" autocomplete="off" class="register" required>
                <p><small id="warnings"></small></p>
            </div>

            <div class="form-field">
                <label for="Sex">
                    Género
                </label><br>
                Masculino:
                <input type="radio" name="sex" id="male" class="register" checked>
                Femenino:
                <input type="radio" name="sex" id="female" class="register"> 
                <p><small id="warnings"></small></p>
            </div>

            <div class="form-field">
                <label for="Password">
                    Password
                </label><br>
                <input type="password" name="password" id="password" placeholder="Password" autocomplete="off" class="register" required>
                <p><small id="warnings"></small></p>
            </div>

            <button type="submit" class="btReg">Registrarse</button>
            <br><br>
            <a href="index.jsp"><button type="button" class="btReg">Volver</button></a>

        </form>
</div>
    </main>

</body>
</html>