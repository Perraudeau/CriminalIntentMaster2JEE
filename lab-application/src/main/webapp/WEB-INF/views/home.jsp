<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false" %>

<html>
<head>
  <title>Final Project</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/bootstrap.min.css' />">
</head>
<body>
  <div class="col-sm-offset-1 col-sm-10">
    <h1>
      Final Project Alexis & Victor!
    </h1>  
	 <ul>
     <li> Ranger et verifier les fichiers POM.xml</li>
     <li> Régler le problème d'utf8 (si possible)</li>
     <li> Noter les RG faites</li>
     <li> Commenter</li>
     <li> Web design (facult)</li>
     <li> Voir la suppression (en vérifiant les cascades ... nirvana)</li>
     </ul>
    
    <hr>
    <p class="lead"><b>Available use-cases are:</b></p>
    <ul>
      <c:forEach var="uc" items="${useCases}">
        <li><p class="lead">${uc}</p></li>
      </c:forEach>
    </ul>
    
    <a href="/services">
   		<button>Liste des services</button>
	</a>
 <a href="/postes">
   <button>Liste des postes</button>
</a>
 <a href="/salaries">
   <button>Liste des salariés</button>
</a>
 <a href="/intentionCriminelles">
   <button>Liste des intentions criminelles</button>
</a>

    <a href="/services/create?new">
   		<button>Ajout d'un service</button>
	</a>
 <a href="/postes/create?new">
   <button>Ajout d'un poste</button>
</a>
 <a href="/salaries/create?new">
   <button>Ajout d'un salarié</button>
</a>
 <a href="/intentionCriminelles/create?new">
   <button>Ajout d'une intention criminelle</button>
</a>


  </div>
</body>