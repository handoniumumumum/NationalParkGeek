package com.techelevator.npgeek.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Weather {

	private int low;
	private int high;
	private String forecast;
	private int day;

	private DecimalFormat rounder = new DecimalFormat("0");
	
	
	public String getLow(String tempFormat) {
		if(tempFormat.equals("Celsius"))
			return rounder.format((low-32)/(1.8));
		else
			return Integer.toString(low);
	}
	public void setLow(int low) {
		this.low = low;
	}
	
	public String getHigh(String tempFormat) {
		if(tempFormat.equals("Celsius"))
			return rounder.format((high-32)/(1.8));
		else
			return Integer.toString(high);
	}
	
	public void setHigh(int high) {
		this.high = high;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getForecast() {
		return forecast.substring(0,1).toUpperCase() + forecast.substring(1);
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getForecastImageLocation()
	{
		if(forecast.equals("partly cloudy"))
			return "partlyCloudy";
		else
			return forecast;
		
	}
	
	public List<String> getForecastWarnings()
	{
		List<String> forecastWarnings = new ArrayList<>();
		
		if(forecast.equals("snow"))
			forecastWarnings.add("You should pack snowshoes today.");
		if(forecast.equals("rain"))
				forecastWarnings.add("Remember to pack rain gear and waterproof shoes today.");
		if(forecast.equals("thunderstorms"))
		{
			forecastWarnings.add("Make sure to seek shelter in case of storms.");
			forecastWarnings.add("Avoid hiking on exposed ridges.");
		}
		if(forecast.equals("sunny"))
			forecastWarnings.add("Pack sunscreen today to avoid getting sunburnt.");
		if(high > 75)
			forecastWarnings.add("Bring extra water with you today in case of dehydration.");
		if((high-low) > 20)
			forecastWarnings.add("Wear breathable layers today in case of sharp temperature changes.");
		if(low < 20)
			forecastWarnings.add("Avoid prolonged exposure to frigid temperatures today.");
		return forecastWarnings;
	}
	
	
	
	
}
