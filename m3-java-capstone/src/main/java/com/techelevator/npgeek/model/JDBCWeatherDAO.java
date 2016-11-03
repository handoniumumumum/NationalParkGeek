package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDAO implements WeatherDAO {
	
private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDAO(DataSource dataSource)
	{
		this.jdbcTemplate = new JdbcTemplate(dataSource);	
	}
	public List<Weather> getFiveDayForecastByCode(String parkCode)
	{
		List<Weather> forecastList = new ArrayList<>();
		
		String sqlGetFiveDayForecastByCode = "SELECT fivedayforecastvalue, low, high, forecast FROM weather "
				+ "WHERE parkcode = ? ORDER BY fivedayforecastvalue ASC;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetFiveDayForecastByCode, parkCode.toUpperCase());
		
		while(result.next())
		{
			Weather currentWeather = new Weather();
			currentWeather.setForecast(result.getString("forecast"));
			currentWeather.setHigh(result.getInt("high"));
			currentWeather.setLow(result.getInt("low"));
			currentWeather.setDay(result.getInt("fivedayforecastvalue"));
			forecastList.add(currentWeather);
		}
		
		return forecastList;
	}

}
