package com.techelevator.npgeek;
import java.sql.SQLException;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.techelevator.npgeek.model.JDBCWeatherDAO;
import com.techelevator.npgeek.model.Weather;

public class JDBCWeatherDAOIntegrationTest extends DAOIntegrationTest {
	
	private JDBCWeatherDAO dao;
	
	public JDBCWeatherDAOIntegrationTest() {
		dao = new JDBCWeatherDAO(super.getDataSource());
		
	}
	
	@Test
	public void get_todays_forecast_for_a_park() throws SQLException
	{
		Weather testWeather = new Weather();
		testWeather.setDay(1);
		testWeather.setForecast("rain");
		testWeather.setHigh(62);
		testWeather.setLow(38);
		
		Weather actualWeather = dao.getFiveDayForecastByCode("CVNP").get(0);
		
		assertNotNull(actualWeather);
		assertEquals(testWeather.getForecast(), actualWeather.getForecast());
		assertEquals(testWeather.getHigh("Fahrenheit"), actualWeather.getHigh("Fahrenheit"));
		assertEquals(testWeather.getLow("Celsius"), actualWeather.getLow("Celsius"));
		assertEquals(testWeather.getDay(), actualWeather.getDay());
		
	}
	

}
