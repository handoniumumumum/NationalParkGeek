package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.ParkDAO;

@Controller
public class ParkWeatherController {
	
	private ParkDAO dao;
	
	@Autowired
	public ParkWeatherController(ParkDAO parkDao){
		this.dao = parkDao;
	}
	
	@RequestMapping("/parkWeather")
	public String showParkWeather(@RequestParam String parkCode, @RequestParam String tempFormat, ModelMap map)
	{
		map.addAttribute("park", dao.getParkByCode(parkCode));
		map.addAttribute("tempFormat", tempFormat);
		return "parkWeather";
	}

}
