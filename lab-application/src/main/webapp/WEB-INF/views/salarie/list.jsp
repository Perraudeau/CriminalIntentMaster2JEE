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
    <h1>Student list</h1>

    <div>
      <table id="dataTable" class="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>RegistrationNb</th>
          </tr>
        <thead>
        <tbody>
          <c:forEach var="student" items="${students}">
            <tr>
              <td>${student.id}</td>
              <td>${student.name}</td>
              <td>${student.registrationNb}</td>
            <tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</body>