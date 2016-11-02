package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.ParkDAO;

@Controller
public class ParkDetailController {
	
	private ParkDAO dao;
	
	@Autowired
	public ParkDetailController(ParkDAO parkDao)
	{
		this.dao = parkDao;
	}
	
	@RequestMapping("/parkDetail")
	public String showParkDetail(@RequestParam String parkCode, ModelMap map)
	{
		map.addAttribute("park", dao.getParkByCode(parkCode));
		return "parkDetail";
	}
	

}
