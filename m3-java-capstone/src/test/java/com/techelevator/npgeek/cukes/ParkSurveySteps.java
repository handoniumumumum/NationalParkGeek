package com.techelevator.npgeek.cukes;

import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.npgeek.pageObject.SurveyInputPage;
import com.techelevator.npgeek.pageObject.SurveyResultsPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParkSurveySteps {
	
	private WebDriver webDriver;
	private SurveyInputPage inputPage;
	private SurveyResultsPage resultsPage;
	
	@Autowired
	public ParkSurveySteps(WebDriver webDriver)
	{
		this.webDriver = webDriver;
		this.inputPage = new SurveyInputPage(webDriver);
		this.resultsPage = new SurveyResultsPage(webDriver);
	}
	
	@Given("^I want to cast a vote for a certain park$")
	public void i_want_to_cast_a_vote_for_a_certain_park() throws Throwable {
	    webDriver.get("http://localhost:8080/m3-java-capstone/surveyInput");

	}

	@When("^my email is (.*)$")
	public void my_email_is_(String email) throws Throwable {
	    inputPage.enterEmail(email);
	}

	@When("^my state is (.*)$")
	public void my_state_is(String state) throws Throwable {
		inputPage.enterState(state);
	    
	}

	@When("^my activity level is (.*)$")
	public void my_activity_level_is(String activityLevel) throws Throwable {
		String formattedActivityLevel = WordUtils.capitalizeFully(activityLevel, ' ');
		inputPage.enterActivityLevel(formattedActivityLevel);
	}
	
	@When("^park is (.*)$")
	public void the_park_is(String park)
	{
		inputPage.enterPark(park);
	}
	

	@Then("^the vote count for that park should increase by (\\d+)$")
	public void the_vote_count_for_that_park_should_increase_by(int votes) throws Throwable {
	    
	}

}
