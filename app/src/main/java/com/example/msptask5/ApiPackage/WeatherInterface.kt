package com.example.msptask5.ApiPackage

import android.telecom.Call
import okhttp3.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInterface {
    @GET(".aspx#current")
    fun GetApi(@Query (ApiKey.apiKey.toString())apiKey:String  ,@Query("Egypt") CountryName:String ):List<Current>
}