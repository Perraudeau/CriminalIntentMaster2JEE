<%@include file="header.jsp" %>


    <h1>
      Projet final Alexis & Victor!
    </h1>  
	 <ul>
     <li> Noter les RG faites</li>
     <li> Commenter</li>
     </ul>
    
    <hr>
    
    
    <p class="lead"><b>Available use-cases are:</b></p>
    <ul>
      <c:forEach var="uc" items="${useCases}">
        <li><p class="lead">${uc}</p></li>
      </c:forEach>
    </ul>

  

  </div>
</body>