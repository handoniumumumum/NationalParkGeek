package com.techelevator.npgeek.model;

import java.util.List;

public interface SurveyDAO {

	public void submit(Survey submittedSurvey);
	public List<SurveyResult> getSurveyResults();

	
}
