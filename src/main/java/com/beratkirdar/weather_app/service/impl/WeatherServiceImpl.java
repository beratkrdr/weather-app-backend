package com.beratkirdar.weather_app.service.impl;

import com.beratkirdar.weather_app.dto.OpenWeatherMapApiResponseDTO;
import com.beratkirdar.weather_app.dto.WeatherResponseDTO;
import com.beratkirdar.weather_app.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WebClient webClient;

    @Value("${weather.api.url}")
    private String weatherApiUrl;

    @Value("${weather.api.key}")
    private String weatherApiKey;

    public WeatherResponseDTO getWeather(String city){

        String url = String.format("%s?q=%s&appid=%s&units=metric", weatherApiUrl, city, weatherApiKey);

        OpenWeatherMapApiResponseDTO weatherApiResponse = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(OpenWeatherMapApiResponseDTO.class)
                .block();

        if (weatherApiResponse == null || weatherApiResponse.getWeather().isEmpty()){
            throw new RuntimeException("Weather data could not obtained.");
        }

        WeatherResponseDTO weatherResponse = new WeatherResponseDTO();
        weatherResponse.setCity(weatherApiResponse.getName());
        weatherResponse.setTemperature(weatherApiResponse.getMain().getTemp());
        weatherResponse.setHumidity(weatherApiResponse.getMain().getHumidity());
        weatherResponse.setDescription(weatherApiResponse.getWeather().get(0).getDescription());

        return weatherResponse;

    }

}
