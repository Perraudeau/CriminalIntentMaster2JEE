
<%@include file="/WEB-INF/views/header.jsp" %>
  <title>Liste des postes</title>
  <div class="col-sm-offset-1 col-sm-10">
    <h1>Liste des postes</h1>

    <div>
      <table id="dataTable" class="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>Libellé</th>
            <th>Service</th>
          </tr>
        <thead>
        <tbody>
          <c:forEach var="poste" items="${postes}">
            <tr>
              <td>${poste.idPoste}</td>
              <td>${poste.libelle}</td>
              <td>${poste.service.getLibelle()}</td>
            <tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

  </div>
</body>