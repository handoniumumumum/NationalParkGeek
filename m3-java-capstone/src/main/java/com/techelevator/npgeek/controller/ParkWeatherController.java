package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.WeatherDAO;

@Controller
@SessionAttributes("tempFormat")
public class ParkWeatherController {
	
	private ParkDAO parkDao;
	private WeatherDAO weatherDao;
	
	@Autowired
	public ParkWeatherController(ParkDAO parkDao, WeatherDAO weatherDao){
		this.parkDao = parkDao;
		this.weatherDao = weatherDao;
	}
	
	@RequestMapping("/parkWeather")
	public String showParkWeather(@RequestParam String parkCode, @RequestParam String tempFormat, ModelMap map)
	{
		map.addAttribute("park", parkDao.getParkByCode(parkCode));
		map.addAttribute("forecast", weatherDao.getFiveDayForecastByCode(parkCode));
		map.addAttribute("tempFormat", tempFormat);
		return "parkWeather";
	}

}
