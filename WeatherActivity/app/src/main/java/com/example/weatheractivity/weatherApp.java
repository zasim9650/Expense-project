package com.example.weatheractivity;

import java.util.List;

public class weatherApp {
    public String base;
    public String clouds;
    public int cod;
//    public Coord coord;
    public int dt;
    public int id;
    public Main main;
    public String name;
    public int timezone;
    public int visibility;
    public List<Weather> weathers;
    public Wind wind;
    public sys ss;

    public weatherApp(String base, String clouds, int cod, Coord coord, int dt, int id, Main main, String name, int timezone, int visibility, List<Weather> weathers, Wind wind, sys ss) {
        this.base = base;
        this.clouds = clouds;
        this.cod = cod;

        this.dt = dt;
        this.id = id;
        this.main = main;
        this.name = name;
        this.timezone = timezone;
        this.visibility = visibility;
        this.weathers = weathers;
        this.wind = wind;
        this.ss = ss;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getClouds() {
        return clouds;
    }

    public void setClouds(String clouds) {
        this.clouds = clouds;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }



    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public List<Weather> getWeathers() {
        return weathers;
    }

    public void setWeathers(List<Weather> weathers) {
        this.weathers = weathers;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public sys getSs() {
        return ss;
    }

    public void setSs(sys ss) {
        this.ss = ss;
    }
}
