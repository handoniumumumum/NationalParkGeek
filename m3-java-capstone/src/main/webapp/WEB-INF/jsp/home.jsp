<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Parks</h1>

<c:forEach var="park" items="${parks}">

	<c:url var="parkDetailHref" value="/parkDetail">
		<c:param name="parkCode" value="${park.code}"/>
	</c:url>

	<div id="park-list-item">
	
			<a href="${parkDetailHref}">
			<img src = "img/parks/${park.code}.jpg"/>
			</a>
		
		<div id="park-list-description">
		
		
		<h2><a href="${parkDetailHref}">${park.name}</a></h2>
		
		<h3>${park.state}</h3>
		<br>
		<p>${park.parkDescription}</p>
		
		
		
		</div>
	
	
	
	</div>
	
</c:forEach>

</body>