package com.techelevator.npgeek.model;

public interface SurveyDAO {

	public void submit(Survey submittedSurvey);
	public SurveyResults getSurveyResults();

	
}
