<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de usuarios</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-expand-md navbar-dark bg-dark">
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="navbar-nav">
						<li>
							<!-- <a href="<%=request.getContextPath()%>/" class="nav-link"></a> -->
						</li>
					</ul>
					</div>
				</nav>

			</div>
		</div>
	</header>
	
	<br>
	
	<div class="container">
		<div class="row">
			<h2>Registro de usuarios</h2>
			<form action="registrarUsuario" method="post">
				
				<fieldset class="form-group">
					<label>Usuario</label> <input type="text" class="form-control"
						name="usuario" required="required" maxlength="20">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Email</label> <input type="text" class="form-control"
						name="email" required="required" maxlength="100">
				</fieldset>

				<fieldset class="form-group">
					<label>Contraseña</label> <input type="text" class="form-control"
						name="pass" required="required" maxlength="50">
				</fieldset>
				<br>
				<button type="submit" class="btn btn-success">Registrar</button>
			</form>
		</div>
	</div>

</body>
</html>