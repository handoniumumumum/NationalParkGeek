package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.ParkDAO;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.SurveyDAO;
import com.techelevator.npgeek.model.SurveyResult;

@Controller
public class SurveyController {
	
	private SurveyDAO surveyDao;
	private ParkDAO parkDao;
	@Autowired
	public SurveyController(SurveyDAO surveyDao, ParkDAO parkDao)
	{
		this.surveyDao = surveyDao;
		this.parkDao = parkDao;
	}
	
	@RequestMapping("/surveyInput")
	public String showSurveyInput(ModelMap map)
	{		map.addAttribute("parks", parkDao.getAllParks());
		return "surveyInput";
	}
	
	@RequestMapping(path="/surveyInput", method=RequestMethod.POST)
	public String submitSurveyResults(@RequestParam String parkCode, @RequestParam String email,
			@RequestParam String state, @RequestParam String physicalActivityLevel)
	{
		Survey submittedSurvey = new Survey();
		submittedSurvey.setEmail(email);
		submittedSurvey.setParkCode(parkCode);
		submittedSurvey.setPhysicalActivityLevel(physicalActivityLevel);
		submittedSurvey.setState(state);
		surveyDao.submit(submittedSurvey);
		
		return "redirect:/surveyResults";
	}
	
	@RequestMapping("/surveyResults")
	public String showSurveyResult(ModelMap map)
	{
		List<SurveyResult> surveyResults = surveyDao.getSurveyResults();
		map.addAttribute("surveyResults", surveyResults);
		return "surveyResults";
	}
	
	
	
	

}
