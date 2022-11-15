<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<header id="main-header">

		<a id="title" href="index.jsp">CAR</a>
		<a id="titleBlue" href="index.jsp">Buy</a>
		<a id="logo-header" href="index.jsp"><img src="Images/logor.png"></a>

		<nav>
			<ul>

				<li style="border-bottom: 2px solid #f0f2f1;"><a
					href="index.jsp">Log in</a></li>
			</ul>
		</nav>

	</header>
	<div id="cuerpo">
		<form action="Main" method="post">

			<div id="login">
				<br>
				<div id="introducir">
					<input type="text" class="usuario" id="usuario" name="usuario"
						placeholder="User" maxlength="50" minlength="1" required>
				</div>
				<div id="introducir">
					<input type="password" class="password" id="password"
						name="password" placeholder="Password" required maxlength="50"
						minlength="1">
				</div>
				<div id="introducir">
					<button type="submit" class="join">
						<h2>Log In</h2>
					</button>
				</div>
				<br>
				¿No tienes cuenta?
				<br><br>
				<div id="registrarse">
					<a href="register.jsp" class=""><button class="registerButton" type="button"><h2>Registrarse</h2></button></a>
				</div>
				

			</div>

		</form>
		
	</div>
</body>
</html>