<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
  <title>Liste des salariés</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/bootstrap.min.css' />">
</head>
<body>
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
    <a href="/">
   		<button>Retour à l'accueil</button>
	</a>
  </div>
</body>