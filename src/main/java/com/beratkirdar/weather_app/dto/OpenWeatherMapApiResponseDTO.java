package com.beratkirdar.weather_app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherMapApiResponseDTO {

    private String name;
    private Main main;
    private List<Weather> weather;

    @Data
    public static class Main{
        private double temp;
        private int humidity;
    }

    @Data
    public static class Weather{
        private String description;
    }

}
