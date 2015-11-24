<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
  <title>Stapp</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/bootstrap.min.css' />">
</head>
<body>
  <div class="col-sm-offset-1 col-sm-10">
    <h1>
      Final Project Alexis & Victor!
    </h1>
    <hr>
    <p class="lead"><b>Available use-cases are:</b></p>
    <ul>
      <c:forEach var="uc" items="${useCases}">
        <li><p class="lead">${uc}</p></li>
      </c:forEach>
    </ul>
  </div>
</body>