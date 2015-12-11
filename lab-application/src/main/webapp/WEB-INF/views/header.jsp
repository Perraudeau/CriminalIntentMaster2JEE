<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=iso-8859-1" %>
<%@ page session="false" %>

<html>
<head>
  <title>Final Project</title>
  <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/bootstrap.min.css' />">
   <link rel="stylesheet"
        type="text/css"
        href="<c:url value='/resources/perso.css' />">
</head>
<body>
  <div class="col-sm-offset-1 col-sm-10">
  <ul id="menu">
	<li><a href="/">Accueil</a>
	</li><!--
 --><li><a href="#">Services</a>
		<ul>
			<li><a href="/services">Liste des services</a></li>
			<li><a href="/services/create?new">Ajouter un service</a></li>
		</ul>
	</li><!--
 --><li><a href="#">Postes</a>
		<ul>
			<li><a href="/postes">Liste des postes</a></li>
			<li><a href="/postes/create?new">Ajouter un poste</a></li>
		</ul>
	</li><!--
 --><li><a href="#">Salariés</a>
		<ul>
			<li><a href="/salaries">Liste des salariés</a></li>
			<li><a href="/salaries/create?new">Ajouter un salariés</a></li>
		</ul>
	</li><!--
 --><li><a href="#">Intentions Criminelles</a>
		<ul>
			<li><a href="/intentionCriminelles">Liste des intentions criminelles</a></li>
			<li><a href="/intentionCriminelles/create?new">Ajouter un intentions criminelles</a></li>
		</ul>
	</li>
</ul>