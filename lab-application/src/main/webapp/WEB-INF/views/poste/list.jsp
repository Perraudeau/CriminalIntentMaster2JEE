<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
  <title>Liste des postes</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/bootstrap.min.css' />">
</head>
<body>
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
    <a href="/">
   		<button>Retour à l'accueil</button>
	</a>
  </div>
</body>