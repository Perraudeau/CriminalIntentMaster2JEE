<%@include file="/WEB-INF/views/header.jsp"%>
<title>Liste des intentions criminelles</title>
<div class="col-sm-offset-1 col-sm-10">
	<h1>Liste des intentions criminelles</h1>

	<div>
		<table id="dataTable" class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Libell&eacute;</th>
					<th>Salari&eacute;</th>
				</tr>
			<thead>
			<tbody>
				<c:forEach var="intentionCriminelle" items="${intentionCriminelles}">
					<tr>
						<td>${intentionCriminelle.idIntentionCriminelle}</td>
						<td>${intentionCriminelle.libelle}</td>
						<td>${intentionCriminelle.salarie.getNom()}
							${intentionCriminelle.salarie.getPrenom()}</td>
					<tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp"%>
</body>