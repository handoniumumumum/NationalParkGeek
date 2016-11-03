<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Daily Survey Results</h1>

<c:forEach var="park" items="${surveyResults.parkList}">
	<p>${park.name} : </p>
	<c:set var="parkCode" value="${fn:toUpperCase(park.code)}"/>
	<p>${parkCode}</p>
	<p>${surveyResults.getVotesByParkCode(parkCode)} votes</p>





</c:forEach>