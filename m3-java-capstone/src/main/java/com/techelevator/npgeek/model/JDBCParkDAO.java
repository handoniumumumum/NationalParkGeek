package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCParkDAO implements ParkDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);	
	}
	
	public List<Park> getAllParks()
	{
		List<Park> allParks = new ArrayList<>();
		
		String sqlSelectAllParks = "SELECT * FROM park;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		
		while(results.next())
		{
			Park park = new Park();
			setParkValues(results, park);
			allParks.add(park);
		}
		
		return allParks;
	}
	
	public Park getParkByCode(String parkCode)
	{
		Park selectedPark = new Park();
		
		String SqlSelectParkByCode = "SELECT * FROM park WHERE parkcode = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(SqlSelectParkByCode, parkCode.toUpperCase());
		if(results.next())
		{
			setParkValues(results, selectedPark);
		}
		return selectedPark;
		
		
	}

	private void setParkValues(SqlRowSet results, Park park) {
		park.setCode(results.getString("parkcode").toLowerCase());
		park.setName(results.getString("parkname"));
		park.setState(results.getString("state"));
		park.setAcreage(results.getInt("acreage"));
		park.setElevationInFeet(results.getInt("elevationinfeet"));
		park.setMilesOfTrail(results.getDouble("milesoftrail"));
		park.setNumberOfCampsites(results.getInt("numberofcampsites"));
		park.setClimate(results.getString("climate"));
		park.setYearFounded(results.getInt("yearfounded"));
		park.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		park.setInspirationalQuote(results.getString("inspirationalQuote"));
		park.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		park.setParkDescription(results.getString("parkdescription"));
		park.setEntryFee(results.getInt("entryfee"));
		park.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
	}
	


}
