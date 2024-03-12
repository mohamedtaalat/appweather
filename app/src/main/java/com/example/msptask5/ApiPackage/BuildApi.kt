package com.example.msptask5.ApiPackage

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


public object BuildApi {
   val api=Retrofit.Builder()
       .baseUrl("https://www.weatherapi.com/api-explorer")
       .addConverterFactory(GsonConverterFactory.create())
       .build()



}