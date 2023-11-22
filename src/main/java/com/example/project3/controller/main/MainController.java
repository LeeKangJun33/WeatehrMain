package com.example.project3.controller.main;

import com.example.project3.service.mainApiService.LocationService;
import com.example.project3.service.mainApiService.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/api")
public class MainController {

    private final WeatherService weatherService;
    private final LocationService locationService;

    @Autowired
    public MainController(WeatherService weatherService, LocationService locationService) {
        this.weatherService = weatherService;
        this.locationService = locationService;
    }

    @GetMapping("/recommendation")
    public Mono<String> getWeatherRecommendation(@RequestParam("latitude") String latitude,
                                                 @RequestParam("longitude") String longitude) {
        // 위치 정보 및 날씨 정보를 이용하여 추천 로직 수행
        return weatherService.getWeather(latitude, longitude)
                .map(weatherResponse -> {
                    // 여기에서 추천 로직을 추가하고 결과를 반환
                    return "옷 추천 결과";
                });
    }


    @GetMapping("/location")
    public Mono<String> getLocationName(@RequestParam double latitude, @RequestParam double longitude) {
        return locationService.getLocationName(latitude, longitude);
    }

}
