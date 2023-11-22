package com.example.project3.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WeatherResponse {

    @JsonProperty("response")
    private Response response;

    // 현재 날짜 및 시간
    private String currentBaseDate;
    private String currentBaseTime;

    // 예보를 위한 기본 날짜 및 시간
    private String forecastBaseDate;
    private String forecastBaseTime;


    // 기타 필요한 필드 추가

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    // 기타 Getter, Setter, toString 등 필요한 메소드 추가

    public static class Response {
        @JsonProperty("header")
        private Header header;

        @JsonProperty("body")
        private Body body;

        // Getter, Setter, toString 등 필요한 메소드 추가

        public static class Header {
            @JsonProperty("resultCode")
            private String resultCode;

            // Getter, Setter, toString 등 필요한 메소드 추가
        }

        public static class Body {
            @JsonProperty("items")
            private Items items;

            // Getter, Setter, toString 등 필요한 메소드 추가

            public static class Items {
                @JsonProperty("item")
                private Item[] item;

                // Getter, Setter, toString 등 필요한 메소드 추가

                public static class Item {
                    @JsonProperty("baseDate")
                    private String baseDate;

                    @JsonProperty("baseTime")
                    private String baseTime;

                    // 기타 필요한 필드 추가

                    // Getter, Setter, toString 등 필요한 메소드 추가
                }
            }
        }
    }
}
