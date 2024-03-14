<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/newportal.css">

<title>Grupos Musicales</title>

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

			<p>
				<br>
			</p>

			<!-- Espacio para la lista de Grupos musicales -->
			<div class="release">
				<span class="welcome">LISTADO DE GRUPOS MUSICALES</span> 
				<br><br>
				
				<!-- Cabecera de la tabla o de la lista -->
				<div class="form-row tableHeaderAll">
					<div class="col">Id</div>
					<div class="col-2">Nombre del grupo</div>
					<div class="col">Año de creación</div>
					<div class="col-2">Origen</div>
					<div class="col-2">Género musical</div>
					<div class="col"></div>
					<div class="col"></div>
					<div class="col"></div>
				</div>
				
				<!-- Filas de datos de la tabla o de la lista -->
				
				<c:forEach items="${listaGrupos}" var="grupo">
					<div class="form-row tableHeaderUser" style="font-size: small;">
						<div class="col">${grupo.grupoId}</div>
						<div class="col-2">${grupo.nombre}</div>
						<div class="col">${grupo.creacion}</div>
						<div class="col-2">${grupo.origen}</div>
						<div class="col-2">${grupo.genero}</div>
						<div class="col">
							<a href="${pageContext.request.contextPath}/emisora/detalle/${grupo.grupoId}">Detalle</a>
						</div>
						<div class="col">
							<a href="${pageContext.request.contextPath}/ServletEmisora?accion=modificar&grupoId=${grupo.grupoId}">Modificar</a>
						</div>
						<div class="col">
							<a href="${pageContext.request.contextPath}/ServletEmisora?accion=baja&grupoId=${grupo.grupoId}">Eliminar</a>
						</div>
					</div>
				</c:forEach>

				<div class="col-11"></div>

			</div>

			<p></p>

			<!-- Espacio para el botón de Añadir grupo -->
			<div class="form-row">
				<div class="col-1"></div>
				 <span class="input-group-btn">
					<input type="button" class="btn btn-info" value="Agregar grupo" onclick="" />
				</span>
			</div>

		</div>
	</div>

</body>

</html>
