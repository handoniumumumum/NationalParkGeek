package com.techelevator.npgeek.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ParkDetailPage {

	private WebDriver webDriver;
	
	public ParkDetailPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		}
	
	public String getParkAcreage() {
		WebElement area = webDriver.findElement(By.id("sizeTest"));
		return area.getText();
	}
}
