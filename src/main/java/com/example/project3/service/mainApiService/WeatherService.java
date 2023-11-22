package com.example.project3.service.mainApiService;


import com.example.project3.dto.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
public class WeatherService {

    @Value("${ryCNXqrBb6PzrL17tTbO4MjxBBfAaYVJhtNWxBAzddWaLNQZjWoQKLXMvqXCqpEBz%2BWaB5dSiGrs1cdCrKjeZg%3D%3D}")
    private String apiKey;

    private final WebClient webClient;

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

}
