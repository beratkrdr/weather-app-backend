package com.beratkirdar.weather_app.dto;

import lombok.Data;

@Data
public class WeatherResponseDTO {

    private String city;
    private double temperature;
    private int humidity;
    private String description;

}
