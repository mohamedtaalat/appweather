package com.example.msptask5.ApiPackage

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 public object BuildApi {
     val api:WeatherInterface by lazy{
        Retrofit.Builder()
            .baseUrl("https://www.weatherapi.com/api-explorer")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WeatherInterface::class.java)

    }



}