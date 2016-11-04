<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Parks</h1>

<c:url value="/surveyInput" var="surveyInputHref"/>
<h2>
	<a href="${surveyInputHref}" > Vote for your favorite park in our daily poll!</a></h2>

<c:forEach var="park" items="${parks}">

	<c:url var="parkDetailHref" value="/parkDetail">
		<c:param name="parkCode" value="${park.code}"/>
	</c:url>

	<div id="park-list-item">
	
			<a id = "${park.name}" href="${parkDetailHref}">
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