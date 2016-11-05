<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<BODY id = "home-background" background="img/parks/${park.code}.jpg">


<section id="forecast-today">
<h2>Today's Forecast for ${park.name}</h2>

	<div id="forecast-image">
		<img src="img/weather/${forecast[0].forecastImageLocation}.png"/>
	
	</div>
	
	<div id="forecast-summary">
		<h3>${forecast[0].forecast}</h3>
		<p>High: ${forecast[0].getHigh(tempFormat)}° ${tempFormat} </p>
		<p>Low: ${forecast[0].getLow(tempFormat)}° ${tempFormat}</p>
	</div>
	
	<div id="forecast-warnings">
		<c:forEach var="warning" items="${forecast[0].forecastWarnings}">
			<p>${warning}</p>
		</c:forEach>
	
	</div>
</section>

<section id="forecast-five">

<h2>Five-day Forecast for ${park.name}</h2>

<table>

	<tr>
	

<c:forEach var="weather" items="${forecast}">
		<td>
			<c:choose>
				<c:when test="${weather.day == 1}">
					<p>Today</p>
				</c:when>
				<c:otherwise>
					<p>Day ${weather.day}</p>
				</c:otherwise>
			</c:choose>
		
		</td>


</c:forEach>

	</tr>
	
	<tr>

<c:forEach var="weather" items="${forecast}">
		<td>
			<img src="img/weather/${weather.forecastImageLocation}.png"/>
		</td>
</c:forEach>

	</tr>
	
	<tr>

<c:forEach var="weather" items="${forecast}">
		<td>
			<p>${weather.forecast}</p>
		
		</td>


</c:forEach>

	</tr>
	<tr>

<c:forEach var="weather" items="${forecast}">
		<td>
			<p>High: ${weather.getHigh(tempFormat)}° ${tempFormat} </p>
		
		</td>


</c:forEach>

	</tr>
	
	<tr>

<c:forEach var="weather" items="${forecast}">
		<td>
			<p>Low: ${weather.getLow(tempFormat)}° ${tempFormat}</p>
		
		</td>


</c:forEach>
	</tr>


</table>


</section>