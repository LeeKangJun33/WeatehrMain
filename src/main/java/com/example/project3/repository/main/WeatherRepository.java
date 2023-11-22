package com.example.project3.repository.main;

import com.example.project3.entity.main.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherRepository extends CrudRepository<Weather, Long> {

    // 날씨 정보를 조회하는 메소드
    List<Weather> findByLocationId(int locationId);
}
