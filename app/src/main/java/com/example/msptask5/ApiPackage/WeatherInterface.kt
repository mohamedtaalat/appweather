package com.example.msptask5.ApiPackage

import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInterface {
    @GET(".aspx#current")
    fun GetApiWeather(@Query (ApiKey.apiKey.toString())apiKey:String  ,@Query("London") CountryName:String ):Call<Current>
}