package com.techelevator.npgeek.model;

import java.util.List;

public interface WeatherDAO {

	public List<Weather> getFiveDayForecastByCode(String parkCode);
}
