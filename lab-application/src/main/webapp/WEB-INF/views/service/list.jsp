<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
  <title>Liste des services</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/bootstrap.min.css' />">
</head>
<body>
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
</body>