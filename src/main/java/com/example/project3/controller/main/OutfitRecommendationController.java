package com.example.project3.controller.main;

import com.example.project3.config.main.Season;
import com.example.project3.service.mainApiService.OutfitRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
public class OutfitRecommendationController {

    @Autowired
    private OutfitRecommendationService outfitRecommendationService;

    @GetMapping("/api/recommendation/outfit")
    public Mono<List<String>> recommendOutfit(@RequestParam("latitude") String latitude,
                                              @RequestParam("longitude") String longitude,
                                              @RequestParam("locationId") int locationId,
                                              @RequestParam("season") Season season) {
        return Mono.just(outfitRecommendationService.recommendOutfit(latitude, longitude, locationId, season));
    }
}
