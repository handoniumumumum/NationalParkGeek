package com.techelevator.npgeek.cukes;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.techelevator.npgeek.pageObject.HomePage;
import com.techelevator.npgeek.pageObject.ParkDetailPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ParkDetailSteps {
	
	private WebDriver webDriver;
	private HomePage homePage;
	private ParkDetailPage detailPage;
	
	@Autowired
	public ParkDetailSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
		this.homePage =  new HomePage(webDriver);
		this.detailPage = new ParkDetailPage(webDriver);
	}
	

	@Given("^I want to know the area of a park$")
	public void i_want_to_know_the_area_of_a_park() throws Throwable {
	    webDriver.get("http://localhost:8080/m3-java-capstone/");
	    
	}

	@When("^the park is (.*)$")
	public void the_park_is(String parkName) throws Throwable {
	   homePage.clickableLink(parkName);
	   
	}

	@Then("^the area is (.*) acres$")
	public void the_area_is_acres(String expectedAcreage) throws Throwable {
	    String parkAcreage =detailPage.getParkAcreage();
	    Assert.assertEquals(expectedAcreage, parkAcreage);
	}
}
