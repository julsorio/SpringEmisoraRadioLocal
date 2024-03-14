<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/newportal.css">

<title>Grupos Musicales - Actualizar grupo musical</title>

</head>

<body class="fondo">

	<div class="container">
		<div class="signup-form-container">

			<!-- Espacio de cabecera -->
			<div class="form-header">
				<h3 class="registration">
					<i class="fa fa-user"></i>Sistema de Gestión de Emisora Local
				</h3>
			</div>

			<!-- Espacio de enlace de Volver-->
			<div class="form-row">
				<div class="col">
					<a href="#" onclick="history.back();">Volver</a>
				</div>
			</div>

			<p></p>

			<!-- Espacio para modificar los datos -->
			<div class="form-row">
				<div class="col-3"></div>
				<div class="col-6">
					<div class="form-body">
						<div class="form-group">
							<div>
								<form:form role="form" id="login-usuarios" autocomplete="off"
									class="credentials" method="post" action="${pageContext.request.contextPath}/emisora/modificar" modelAttribute="grupo" >
									Actualizar grupo musical
									<p></p>

									<div class="input-group">
										<form:input name="grupoId" type="text" disabled="true"
											class="form-control fontAwesome" path="grupoId" />
											<form:hidden path="grupoId" />
									</div>
									<p></p>

									<div class="input-group">
										<form:input name="nombre" type="text"
											class="form-control fontAwesome" path="nombre" />
									</div>
									<p></p>
									<div class="input-group">
										<form:input name="creacion" type="text"
											class="form-control fontAwesome" path="creacion" />
									</div>
									<p></p>

									<div class="input-group">
										<form:select name="origen" id="origen"
											class="form-control fontAwesome" path="origen">
											<form:option value="Estados Unidos" />
											<form:option value="Reino Unido" />
											<form:option value="Australia" />
											<form:option value="España" />
											<form:option value="Alemania" />
										</form:select>
									</div>
									<p></p>

									<div class="input-group">
										<form:select name="genero" id="genero"
											class="form-control fontAwesome" path="genero">
											<form:option value="Heavy Metal" />
											<form:option value="Hard rock" />
											<form:option value="Rock" />
											<form:option value="Folk metal" />
											<form:option value="Rock andaluz" />
										</form:select>
									</div>
									<p></p>

									<span class="input-group-btn">
										<button type="submit" class="btn btn-info">Guardar</button>
									</span> <span class="input-group-btn">
										<button type="reset" class="btn btn-info"
											onclick="history.back();">Cancelar</button>
									</span>

								</form:form>
							</div>

						</div>
					</div>
				</div>

			</div>
			
			<!-- Espacio para el mensaje -->
			<div class="form-row">
				<div class="col error">
					<c:out value="${error}"></c:out>
				</div>
			</div>

		</div>
	</div>

</body>
</html>
