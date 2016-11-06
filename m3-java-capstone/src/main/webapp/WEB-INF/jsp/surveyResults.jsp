<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:import url="/WEB-INF/jsp/common/header.jsp" />

<BODY id = "home-background" background="img/parks/rmnp.jpg">

<section id="survey-results-section">
<h1>Daily Survey Results</h1>

<c:forEach var="parkEntry" items="${surveyResults}">
	<p>${parkEntry.park.name} : ${parkEntry.votes} votes</p>
</c:forEach>
</section>