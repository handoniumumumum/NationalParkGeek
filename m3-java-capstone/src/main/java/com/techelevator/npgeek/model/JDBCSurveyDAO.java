package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDAO implements SurveyDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCSurveyDAO(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void submit(Survey submittedSurvey)
	{
		int id = getNextId();
		String sqlSubmitSurvey = "INSERT INTO survey_result (surveyid, parkcode, "
				+ "emailaddress, state, activitylevel) VALUES (?, ?, ?, ?, ?);";
		jdbcTemplate.update(sqlSubmitSurvey, id, submittedSurvey.getParkCode(),
				submittedSurvey.getEmail(), submittedSurvey.getState(), submittedSurvey.getPhysicalActivityLevel());
	}
	
	private int getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyId')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		int id = 0;
		if(results.next()) {
			id = results.getInt(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next forum post id from sequence");
		}
		return id;
	}

	@Override
	public List<SurveyResult> getSurveyResults() {
		
		List<SurveyResult> surveyResults = new ArrayList<>();
		
		String sqlGetSurveyResults = "SELECT survey_result.parkcode, parkname, COUNT(emailaddress) AS votes FROM survey_result "
				+ "JOIN park ON park.parkcode = survey_result.parkcode "
				+ "GROUP BY survey_result.parkcode, park.parkname ORDER BY votes DESC;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetSurveyResults);
		
		while(results.next())
		{
			Park selectedPark = new Park();
			selectedPark.setName(results.getString("parkname"));
			selectedPark.setCode(results.getString("parkcode"));
			int votes = results.getInt("votes");
			
			SurveyResult surveyResult = new SurveyResult();
			surveyResult.setPark(selectedPark);
			surveyResult.setVotes(votes);
			
			surveyResults.add(surveyResult);
		}
		return surveyResults;
	}

}
