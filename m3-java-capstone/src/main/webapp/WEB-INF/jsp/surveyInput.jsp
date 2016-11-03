<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<h1>National Park Survey</h1>

<c:url value="/surveyInput" var ="formAction"/>
	<form method="POST" action ="${formAction}">
		<div>
			<label for = "park">Choose a park</label>
			<select name="parkCode" id = "parkCode">
				<c:forEach var="park" items="${parks}">
					<option value="${park.code}">${park.name}</option>
				</c:forEach>
				</select>
			
			<label for="state">Enter your state of residence</label>
			<input type="text" name="state" id = "state"/>
			
			<label for= "email">Enter your email address</label>
			<input type="text" name="email" id = "email"/>
			
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