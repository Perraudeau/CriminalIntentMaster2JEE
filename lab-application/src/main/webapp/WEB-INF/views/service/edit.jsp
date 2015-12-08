<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
  <title>Service</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/bootstrap.min.css' />">
</head>
<body>
  <div class="col-sm-offset-1 col-sm-10">
    <h2>Créer un service</h2>

    <form class="form-horizontal" method="POST">
      <div class="form-group">
        <label for="service_libelle" class="col-sm-2 control-label">Libellé</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="service_libelle" name="libelle" />
        </div>
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
