package com.example.project3.service.mainApiService;


import com.example.project3.dto.response.WeatherResponse;
import com.example.project3.entity.main.Weather;
import com.example.project3.repository.main.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Value("${ryCNXqrBb6PzrL17tTbO4MjxBBfAaYVJhtNWxBAzddWaLNQZjWoQKLXMvqXCqpEBz%2BWaB5dSiGrs1cdCrKjeZg%3D%3D}")
    private String apiKey;
    private final WebClient webClient;

    public Flux<WeatherResponse> findByLocationId(int locationId) {
        List<WeatherResponse> responses = weatherRepository.findByLocationId(locationId)
                .stream()
                .map(this::mapToWeatherResponse)
                .collect(Collectors.toList());

        return Flux.fromIterable(responses);
    }

    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService/getVilageFcst")
                .build();
    }

    public Mono<WeatherResponse> getWeather(String latitude, String longitude) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("serviceKey", apiKey)
                        .queryParam("lat", latitude)
                        .queryParam("lon", longitude)
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class);
    }

    private WeatherResponse mapToWeatherResponse(Weather weather) {
        WeatherResponse response = new WeatherResponse();
        response.setTemperature(weather.getTemperature());
        response.setWeatherDescription(weather.getWeather_description());
        response.setForecastDate(weather.getForecast_date());
        response.setWeatherCondition(weather.getWeather_condition());
        response.setTemperatureMax(weather.getTemperature_max());
        response.setTemperatureMin(weather.getTemperature_min());
        response.setHumidity(weather.getHumidity());
        response.setWindSpeed(weather.getWind_speed());
        response.setPrecipitation(weather.getPrecipitation());
        response.setWeatherImg(weather.getWeather_img());
        response.setObservationTime(weather.getObservation_time());
        response.setLocationId(weather.getLocation_id());
        return response;

    }
}
