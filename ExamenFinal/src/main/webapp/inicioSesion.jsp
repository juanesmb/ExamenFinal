<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio de sesión</title>
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
			<h2>Inicio de sesion</h2>
			<form action="iniciarSesion" method="post">
				
				<fieldset class="form-group">
					<label>Usuario</label> <input type="text" class="form-control"
						name="usuario" required="required" maxlength="20">
				</fieldset>

				<fieldset class="form-group">
					<label>Contraseña</label> <input type="text" class="form-control"
						name="pass" required="required" maxlength="50">
				</fieldset>
				
				<br> 
				
				<select class="form-select" aria-label="Default select example" name="rolId">
					<option selected>Seleccione rol</option>
					<c:forEach var="i" items="${roles}">
						<option value="${i.id}">
						"${i.description}"
						</option>
					</c:forEach>
				</select> 
				
				<br>
				<button type="submit" class="btn btn-success">iniciar Sesión</button>
			</form>
		</div>
	</div>

</body>
</html>