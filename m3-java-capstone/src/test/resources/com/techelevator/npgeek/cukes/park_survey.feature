Feature: Park Survey

	Scenario: Vote for a park
	Given I want to cast a vote for a certain park
	When the park is Cuyahoga Valley National Park
	And my email is brandon@brandon.com
	And my state is Ohio
	And my activity level is couch potato
	Then the vote count for that park should increase by 1