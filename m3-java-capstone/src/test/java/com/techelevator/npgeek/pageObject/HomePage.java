package com.techelevator.npgeek.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	
	private WebDriver webDriver;
	
	public HomePage(WebDriver webDriver) {
		this.webDriver=webDriver;
	}
	
	public ParkDetailPage clickableLink(String parkName) {
		WebElement parkLink = webDriver.findElement(By.id(parkName));
		parkLink.click();
		return new ParkDetailPage(webDriver);
	}

}
