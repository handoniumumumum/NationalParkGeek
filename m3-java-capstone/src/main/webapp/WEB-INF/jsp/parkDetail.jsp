<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<p id=inspirational-quote>${park.inspirationalQuote} - ${park.inspirationalQuoteSource}</p>

<h1>${park.name}</h1>

<div id="park-detail-image">
			<img src = "img/parks/${park.code}.jpg"/>
</div>

<div id="park-detail-text">		
		<p><b>State</b>: ${park.state}</p>
		<p><b>Established</b>: ${park.yearFounded}</p>
		<p id="park-description">${park.parkDescription}</p>
		
		<h3 id="fast-facts-header">Fast Facts</h3>
		<div class="fast-facts">
		
		<p><b>Size</b>: ${park.acreage} acres</p>
		<p><b>Elevation</b>: ${park.elevationInFeet} feet</p>
		<p><b>Combined trail length</b>: ${park.milesOfTrail} miles</p>
		<p><b>Number of campsites</b>: ${park.numberOfCampsites}</p>
		</div>
		<div class="fast-facts">
		<p><b>Climate</b>: ${park.climate}</p>
		<p><b>Annual visitors</b>: ${park.annualVisitorCount}</p>
		<p><b>Number of animal species</b>: ${park.numberOfAnimalSpecies}</p>
		<!--if statement, if park is free, say free  -->
		<p><b>Entry fee</b>: $${park.entryFee}</p>
		</div>
		
		
	</div>