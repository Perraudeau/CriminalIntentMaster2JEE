<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
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
	 <ul>
     <li> Faire les Edits de chaque entity </li>
     <li> Régler le problème d'utf8 (si possible)</li>
     <li> Faire des règles métiers pour éviter de créer plusieurs services(postes ....) ou null</li>
     <li> Faire un lien de retour sur le menu  sur chaque page</li>
     <li> Vérifier que l'on peut créer plusieurs postes au meme service</li>
     <li> Plusieurs salariés peuvent appartenir au meme poste</li>
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