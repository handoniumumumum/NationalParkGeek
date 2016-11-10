package com.techelevator.npgeek.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SurveyInputPage {
	
	private WebDriver webDriver;
	
	public SurveyInputPage(WebDriver webDriver)
	{
		this.webDriver = webDriver;
	}
	
	public SurveyInputPage enterEmail(String email)
	{
		WebElement emailField = webDriver.findElement(By.name("email"));
		emailField.sendKeys(email);
		return this;
	}
	
	public SurveyInputPage enterState(String state)
	{
		WebElement stateField = webDriver.findElement(By.name("state"));
		stateField.sendKeys(state);
		return this;
	}
	
	public SurveyInputPage enterPark(String park)
	{
		Select parkSelection = new Select(webDriver.findElement(By.name("parkCode")));
		parkSelection.selectByVisibleText(park);
		return this;
	}
	
	public SurveyInputPage enterActivityLevel(String activityLevel)
	{
		Select physicalActivityLevel = new Select(webDriver.findElement(By.name("physicalActivityLevel")));
		physicalActivityLevel.selectByValue(activityLevel);
		return this;
	}
	
	public SurveyResultsPage submitForm()
	{
		WebElement submitButton = webDriver.findElement(By.id("submitSurvey"));
		submitButton.click();
		return new SurveyResultsPage(webDriver);
	}

}
