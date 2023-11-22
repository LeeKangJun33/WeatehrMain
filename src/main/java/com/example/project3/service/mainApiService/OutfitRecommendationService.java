package com.example.project3.service.mainApiService;

import com.example.project3.config.main.Season;
import com.example.project3.dto.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class OutfitRecommendationService {

    @Autowired
    private WeatherService weatherService;

    // 사용자의 선호도 등을 고려하여 옷을 추천하는 로직
    public List<String> recommendOutfit(String latitude, String longitude, int locationId, Season season) {
        Mono<WeatherResponse> weatherResponseMono = weatherService.getWeather(latitude, longitude);
        WeatherResponse weatherResponse = weatherResponseMono.block();

        // 예시로 간단하게 날씨와 계절에 따라 옷을 추천하는 로직
        if (weatherResponse != null) {
            double temperature = weatherResponse.getTemperature();
            String weatherCondition = weatherResponse.getWeatherCondition();

            if (season == Season.WINTER) {
                if (temperature < 5) {
                    return Arrays.asList("Heavy coat", "Scarf", "Gloves", "Winter boots");
                } else if (temperature < 15) {
                    return Arrays.asList("Jacket", "Sweater", "Jeans", "Winter boots");
                } else {
                    return Arrays.asList("Sweater", "Jeans", "Boots");
                }
            } else if (season == Season.SPRING || season == Season.FALL) {
                if (temperature < 10) {
                    return Arrays.asList("Light jacket", "Sweater", "Jeans", "Sneakers");
                } else if (temperature < 20) {
                    return Arrays.asList("T-shirt", "Jeans", "Sneakers");
                } else {
                    return Arrays.asList("Shorts", "T-shirt", "Sandals");
                }
            } else if (season == Season.SUMMER) {
                if (temperature < 25) {
                    return Arrays.asList("Shorts", "T-shirt", "Sneakers");
                } else {
                    return Arrays.asList("Shorts", "Tank top", "Sandals");
                }
            }
        }

        // 기타 경우에 대한 디폴트 값
        return Collections.emptyList();
    }
}

