<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>Daily Survey Results</h1>

<c:forEach var="parkEntry" items="${surveyResults}">
	<p>${parkEntry.park.name} : </p>
	<p>${parkEntry.votes} votes</p>





</c:forEach>