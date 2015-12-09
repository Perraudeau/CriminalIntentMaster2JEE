<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
  <title>Intention criminelle</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/bootstrap.min.css' />">
</head>
<body>
  <div class="col-sm-offset-1 col-sm-10">
    <h2>Créer une intention criminelle</h2>
    <form class="form-horizontal" method="POST">
      <div class="form-group">
        <label for="intentionCriminelle_libelle" class="col-sm-2 control-label">Libellé</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="intentionCriminelle_libelle" name="libelle" />
        </div>
      </div>
      <div class="form-group">
        <label for="intentionCriminelle_salarie" class="col-sm-2 control-label">Nom du suspect</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="intentionCriminelle_salarie" name="salarie" />
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
