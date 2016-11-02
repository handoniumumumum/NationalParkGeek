Feature: Park Detail

	Scenario: Get total area of selected park
		Given I want to know the area of a park
		When the park is Cuyahoga Valley National Park
		Then the area is 32832 acres