
<%@include file="/WEB-INF/views/header.jsp" %>

  <title>Ajouter un service</title>


	<div class="col-sm-offset-1 col-sm-10">
		<h2>Créer un service</h2>
		<form class="form-horizontal" method="POST">
			<div class="form-group">
				<label for="service_libelle" class="col-sm-2 control-label">Libellé</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="service_libelle"
						name="libelle" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Envoyer</button>
				</div>
			</div>
		</form>

	</div>
</body>