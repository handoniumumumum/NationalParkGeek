package com.techelevator.npgeek;

import java.sql.SQLException;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.techelevator.npgeek.model.JDBCSurveyDAO;
import com.techelevator.npgeek.model.Survey;

public class JDBCSurveyDAOIntegrationTest extends DAOIntegrationTest{

	private static final int TEST_ID = 133333337;
	private JDBCSurveyDAO dao;
	
	public JDBCSurveyDAOIntegrationTest()
	{
		dao = new JDBCSurveyDAO(super.getDataSource());
	}
	
	@Test
	public void save_survey_and_read_it_back() throws SQLException
	{
		Survey testSurvey = new Survey();
		testSurvey.setEmail("test@test.com");
		testSurvey.setParkCode("MRNP");
		testSurvey.setPhysicalActivityLevel("inactive");
		testSurvey.setState("test");
		testSurvey.setId(TEST_ID);
		dao.submit(testSurvey,TEST_ID);
		
		Survey actualSurvey = dao.getSurveyResultById(TEST_ID);
		
		assertNotNull(actualSurvey);
		assertEquals(testSurvey.getEmail(), actualSurvey.getEmail());
		assertEquals(testSurvey.getId(), actualSurvey.getId());
		assertEquals(testSurvey.getParkCode(), actualSurvey.getParkCode());
		assertEquals(testSurvey.getPhysicalActivityLevel(), actualSurvey.getPhysicalActivityLevel());
		assertEquals(testSurvey.getState(), actualSurvey.getState());
		
	}
}
