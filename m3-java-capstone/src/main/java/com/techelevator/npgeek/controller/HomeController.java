package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.npgeek.model.ParkDAO;

@Controller
public class HomeController {
	
	private ParkDAO dao;
	
	@Autowired
	public HomeController(ParkDAO parkDao)
	{
		this.dao = parkDao;
	}
	
	
	@RequestMapping({"/", "/home"})
	public String showHome(ModelMap model)
	{
		model.addAttribute("parks", dao.getAllParks());
		return "home";
	}
	
	

}
