package com.example.mehrabpatwary.weatherapplication;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CurrentWeatherAPI {

    @GET()
    Call<CurrentWeatherResponse> getCurrentWeather();
}
