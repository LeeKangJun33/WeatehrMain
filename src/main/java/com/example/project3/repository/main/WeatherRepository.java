package com.example.project3.repository.main;

import com.example.project3.entity.main.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
