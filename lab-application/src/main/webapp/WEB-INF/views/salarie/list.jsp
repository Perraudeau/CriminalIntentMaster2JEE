
<%@include file="/WEB-INF/views/header.jsp" %>


  <title>Liste des salariés</title>

  <div class="col-sm-offset-1 col-sm-10">
    <h1>Liste des salariés</h1>

    <div>
      <table id="dataTable" class="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>Nom</th>
            <th>Prenom</th>
            <th>Poste</th>
          </tr>
        <thead>
        <tbody>
          <c:forEach var="salarie" items="${salaries}">
            <tr>
              <td>${salarie.idSalarie}</td>
              <td>${salarie.nom}</td>
              <td>${salarie.prenom}</td>
              <td>${salarie.poste.getLibelle()}</td>
            <tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

  </div>
</body>