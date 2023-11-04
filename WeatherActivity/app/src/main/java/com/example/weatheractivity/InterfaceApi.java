package com.example.weatheractivity;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceApi {
    @GET("weather")
    Call<weatherApp> gateData(
            @Query("q") String city_name,
            @Query("appid") String APIKEY,
            @Query("units") String units
    );
}
