package com.example.mehrabpatwary.weatherapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ForecastApi {

   @GET("forecast?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22")

   Call<ForecastWeatherResponse>getForecastWeather(@Url String urlString);

   }
