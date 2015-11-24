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
    <h2>Create a student</h2>

    <form class="form-horizontal" method="POST">
      <div class="form-group">
        <label for="student_name" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="student_name" name="name" />
        </div>
      </div>
      <div class="form-group">
        <label for="student_registration_nb" class="col-sm-2 control-label">Registration nb</label>
        <div class="col-sm-4">
          <input type="text" class="form-control" id="student_registration_nb" name="registrationNb" />
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
