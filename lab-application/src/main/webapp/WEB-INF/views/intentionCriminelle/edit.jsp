<%@include file="/WEB-INF/views/header.jsp" %>
  <title>Ajouter une intention criminelle</title>
  <div class="col-sm-offset-1 col-sm-10">
    <h2>Ajouter une intention criminelle</h2>
    <form class="form-horizontal" method="POST">
      <div class="form-group">
        <label for="intentionCriminelle_libelle" class="col-sm-2 control-label">Libellé</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="intentionCriminelle_libelle" name="libelle" />
        </div>
      </div>
      
      <div class="form-group">
				<label for="intentionCriminelle_salarie" class="col-sm-2 control-label">Employé</label>
				 <select name = "salarie">
				 <div class="col-sm-4">
					<c:forEach var="salarie" items="${salaries}">
          			<option id="intentionCriminelle_salarie" value='${salarie.nom}'>${salarie.nom} ${salarie.prenom}</option>
          			</c:forEach>
          			</div>
          </select>
		</div>
		
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-default">Envoyer</button>
        </div>
      </div>
    </form>
  </div>
</body>
