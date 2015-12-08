<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
  <title>Liste des intentions criminelles</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/bootstrap.min.css' />">
</head>
<body>
  <div class="col-sm-offset-1 col-sm-10">
    <h1>Liste des intentions criminelles</h1>

    <div>
      <table id="dataTable" class="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>Libellé</th>
            <th>Salarié</th>
          </tr>
        <thead>
        <tbody>
          <c:forEach var="intentionCriminelle" items="${intentionCriminelles}">
            <tr>
              <td>${intentionCriminelle.idIntentionCriminelle}</td>
              <td>${intentionCriminelle.libelle}</td>
              <td>${intentionCriminelle.salarie.getNom()} ${intentionCriminelle.salarie.getPrenom()}</td>
            <tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</body>