<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de DB</title>
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
			<h2>Registro de base de datos</h2>
			<form action="registrarDB" method="post">
				
				<fieldset class="form-group">
					<label>id</label> <input type="text" class="form-control"
						name="id" required="required" maxlength="20">
				</fieldset>

				<fieldset class="form-group">
					<label>Descripción</label> <input type="text" class="form-control"
						name="descripcion" required="required" maxlength="100">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Driver</label> <input type="text" class="form-control"
						name="driver" required="required" maxlength="200">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Adicional</label> <input type="text" class="form-control"
						name="aditional" required="required" maxlength="500">
				</fieldset>
				<br>
				<button type="submit" class="btn btn-success">Registrar DB</button>
			</form>
		</div>
	</div>

</body>
</html>