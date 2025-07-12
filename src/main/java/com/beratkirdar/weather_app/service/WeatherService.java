package com.beratkirdar.weather_app.service;

import com.beratkirdar.weather_app.dto.WeatherResponseDTO;

public interface WeatherService {

    WeatherResponseDTO getWeather(String city);

}
