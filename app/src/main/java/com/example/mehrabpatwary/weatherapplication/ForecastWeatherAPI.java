package com.example.mehrabpatwary.weatherapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ForecastWeatherAPI {

   @GET()

   Call<ForecastWeatherResponse>getForecastWeather(@Url String urlString);

   }
