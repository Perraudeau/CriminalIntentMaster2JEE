<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page session="false"%>

<html>
<head>
<title>Salarié</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/bootstrap.min.css' />">
</head>
<body>
	<div class="col-sm-offset-1 col-sm-10">
		<h2>Créer un salarié</h2>
		<form class="form-horizontal" method="POST">
			<div class="form-group">
				<label for="salarie_nom" class="col-sm-2 control-label">Nom</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="salarie_nom" name="nom" />
				</div>
			</div>
			<div class="form-group">
				<label for="salarie_prenom" class="col-sm-2 control-label">Prénom</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="salarie_prenom"
						name="prenom" />
				</div>
			</div>
			<div class="form-group">
				<label for="salarie_poste" class="col-sm-2 control-label">Poste</label>
				 <select name = "poste">
					<c:forEach var="poste" items="${postes}">
          			<option id="salarie_poste" value="'${poste.libelle}'">${poste.libelle}</option>
          			</c:forEach>
          </select>
				<!-- <div class="col-sm-4">
					<input type="text" class="form-control" id="salarie_poste"
						name="poste" />
				</div> -->
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Envoyer</button>
				</div>
			</div>
		</form>
		
	</div>
</body>