<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
  <title>Salari�</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/bootstrap.min.css' />">
</head>
<body>
  <div class="col-sm-offset-1 col-sm-10">
    <h2>Cr�er un salari�</h2>

    <form class="form-horizontal" method="POST">
      <div class="form-group">
        <label for="salarie_nom" class="col-sm-2 control-label">Nom</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="salarie_nom" name="nom" />
        </div>
      </div>
      <div class="form-group">
        <label for="salarie_prenom" class="col-sm-2 control-label">Pr�nom</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="salarie_prenom" name="prenom" />
        </div>
      </div>
      <div class="form-group">
        <label for="salarie_poste" class="col-sm-2 control-label">Poste</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="salarie_poste" name="poste" />
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-default">Submit</button>
        </div>
      </div>
    </form>
  </div>
</body>
