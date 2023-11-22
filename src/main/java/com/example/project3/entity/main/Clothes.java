package com.example.project3.entity.main;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Clothes")
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clothes_id")
    private Long clothesId;

    @Column(name = "top")
    private String top;

    @Column(name = "Bottom")
    private String Bottom;

    @Column(name = "weather_id")
    private Long weatherId;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "clothe_img")
    private String clotheImg;

}
