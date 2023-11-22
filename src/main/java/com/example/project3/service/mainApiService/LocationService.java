package com.example.project3.service.mainApiService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class LocationService {

    private final WebClient webClient;
    private final String apiKey;

    public LocationService(WebClient.Builder webClientBuilder, @Value("${AIzaSyD8OYUmNWgqnjhTwn9KZh0SsM7603m7Mro}") String apiKey) {
        this.webClient = webClientBuilder.baseUrl("https://maps.googleapis.com").build();
        this.apiKey = apiKey;
    }

    public Mono<String> getLocationName(double latitude, double longitude) {
        return webClient.get()
                .uri("/maps/api/geocode/json?latlng={latitude},{longitude}&key={AIzaSyD8OYUmNWgqnjhTwn9KZh0SsM7603m7Mro}", latitude, longitude, apiKey)
                .retrieve()
                .bodyToMono(String.class);
    }
}

