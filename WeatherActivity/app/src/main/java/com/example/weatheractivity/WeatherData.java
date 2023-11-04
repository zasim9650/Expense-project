package com.example.weatheractivity;

import java.util.List;

public class WeatherData {
    private List<weather> weather;
    private main main;
    private String name;

    public WeatherData(List<com.example.weatheractivity.weather> weather, com.example.weatheractivity.main main, String name) {
        this.weather = weather;
        this.main = main;
        this.name = name;
    }

    public List<com.example.weatheractivity.weather> getWeather() {
        return weather;
    }

    public void setWeather(List<com.example.weatheractivity.weather> weather) {
        this.weather = weather;
    }

    public com.example.weatheractivity.main getMain() {
        return main;
    }

    public void setMain(com.example.weatheractivity.main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
