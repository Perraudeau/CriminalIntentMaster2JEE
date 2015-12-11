
<%@include file="/WEB-INF/views/header.jsp" %>

  <title>Liste des services</title>


  <div class="col-sm-offset-1 col-sm-10">
    <h1>Liste des services</h1>

    <div>
      <table id="dataTable" class="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>Libellé</th>
        
          </tr>
        <thead>
        <tbody>
          <c:forEach var="service" items="${services}">
            <tr>
              <td>${service.idService}</td>
              <td>${service.libelle}</td>
            <tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

  </div>
  <%@include file="/WEB-INF/views/footer.jsp" %>
</body>