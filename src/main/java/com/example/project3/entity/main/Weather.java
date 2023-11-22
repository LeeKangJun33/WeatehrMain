package com.example.project3.entity.main;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private Long weatherId;

    @Column(name = "temperature")
    private double temperature;

    @Column(name = "weather_description")
    private String weather_description;

    @Column(name = "forecast_date")
    private Date forecast_date;

    @Column(name = "weather_condition")
    private String weather_condition;

    @Column(name = "temperature_max")
    private double temperature_max;

    @Column(name = "temperature_min")
    private double temperature_min;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "wind_speed")
    private double wind_speed;

    @Column(name = "precipitation")
    private double precipitation;

    @Column(name = "weather_img")
    private String weather_img;

    @Column(name = "observation_time")
    private LocalDateTime observation_time;

    @Column(name = "location_id")
    private int location_id;

}
