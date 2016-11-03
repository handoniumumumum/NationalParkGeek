package com.techelevator.npgeek.model;

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
	public SurveyResults getSurveyResults() {
		
		SurveyResults surveyResults = new SurveyResults();
		
		String sqlGetSurveyResults = "SELECT parkcode, COUNT(emailaddress) AS votes FROM survey_result "
				+ "GROUP BY parkcode ORDER BY votes DESC;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetSurveyResults);
		
		while(results.next())
		{
			String parkCode = results.getString("parkcode");
			int votes = results.getInt("votes");
			surveyResults.addParkAndVote(parkCode, votes);
		}
		return surveyResults;
	}

}
