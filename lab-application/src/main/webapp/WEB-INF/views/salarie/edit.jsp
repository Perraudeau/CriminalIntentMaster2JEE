<%@include file="/WEB-INF/views/header.jsp"%>

<title>Ajouter un salari&eacute;</title>

<div class="col-sm-offset-1 col-sm-10">
	<h2>Ajouter un salari&eacute;</h2>
	<form class="form-horizontal" method="POST">
		<div class="form-group">
			<label for="salarie_nom" class="col-sm-2 control-label">Nom</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="salarie_nom" name="nom" />
			</div>
		</div>
		<div class="form-group">
			<label for="salarie_prenom" class="col-sm-2 control-label">Pr
				&eacute;nom</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" id="salarie_prenom"
					name="prenom" />
			</div>
		</div>
		<div class="form-group">
			<label for="salarie_poste" class="col-sm-2 control-label">Poste</label>

			<div class="col-sm-4">
				<select name="poste">
					<c:forEach var="poste" items="${postes}">
						<option id="salarie_poste" value='${poste.libelle}'>${poste.libelle}</option>
					</c:forEach>
				</select>
			</div>

		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Envoyer</button>
			</div>
		</div>
	</form>

</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>