<%@include file="header.jsp"%>
<br>
<h1>Projet final Alexis & Victor!</h1>
<hr>

<div>
	<p class="lead">
		<b>Les r&eacute;gles de gestion misent en place sont :</b>
	</p>
	<ul>
		<c:forEach var="rg" items="${regleGestion}">
			<li><p class="lead">${rg}</p></li>
		</c:forEach>
	</ul>
</div>
<%@include file="footer.jsp"%>
</body>