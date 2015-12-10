<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<title>Poste</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/bootstrap.min.css' />">
</head>
<body>
	<div class="col-sm-offset-1 col-sm-10">
		<h2>Créer un poste</h2>
		<form class="form-horizontal" method="POST">
			<div class="form-group">
				<label for="poste_libelle" class="col-sm-2 control-label">Libelle</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="poste_libelle"
						name="libelle" />
				</div>
			</div>
			<div class="form-group">
				<label for="poste_service" class="col-sm-2 control-label">Service</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="poste_service"
						name="service" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Envoyer</button>
				</div>
			</div>
		</form>
		<a href="/">
   		<button>Retour à l'accueil</button>
	</a>
	</div>
</body>