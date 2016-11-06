<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<BODY id = "home-background" background="img/parks/ynp2.jpg">

<section id="survey-input-section">
<h1>National Park Survey: Vote for your favorite park!</h1>

<c:url value="/surveyInput" var ="formAction"/>
	<form method="POST" action ="${formAction}">
		<div>
			<label for = "park">Choose your favorite park</label>
			<select name="parkCode" id = "parkCode">
				<c:forEach var="park" items="${parks}">
					<option value="${fn:toUpperCase(park.code)}">${park.name}</option>
				</c:forEach>
				</select>
			<br><br>
			<label for="state">Enter your state of residence</label>
			<input type="text" name="state" id = "state"/>
			<br><br>
			<label for= "email">Enter your email address</label>
			<input type="text" name="email" id = "email"/>
			<br><br>
			<label for = "physicalActivityLevel">What is your average activity level</label>
				<select name = "physicalActivityLevel" id = "physicalActivityLevel">
					<option value="inactive">Inactive</option>
					<option value = "couchPotato">Couch Potato</option>
					<option value = "active">Active</option>
					<option value = "extremelyActive">Extremely Active</option> 
				</select>
				
				<input type ="submit" value = "Submit Survey" id = "submitSurvey"/>
		</div>
	</form>
	</section>