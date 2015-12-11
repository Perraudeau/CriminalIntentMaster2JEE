<%@include file="header.jsp" %>


    <h1>
      Projet final Alexis & Victor!
    </h1>  
	 <ul>
     <li> Commenter</li>
     </ul>
    
    <hr>
    
    <div>  
  	<p class="lead"><b>Les règles de gestion misent en place sont :</b></p>
    <ul>
      <c:forEach var="rg" items="${regleGestion}">
        <li><p class="lead">${rg}</p></li>
      </c:forEach>
    </ul>
  

  </div>
<%@include file="footer.jsp" %>
</body>