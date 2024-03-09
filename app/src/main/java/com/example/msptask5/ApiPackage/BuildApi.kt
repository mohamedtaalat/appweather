package com.example.msptask5.ApiPackage

import retrofit2.Retrofit


 public object BuildApi {
   val api=Retrofit.Builder()
       .baseUrl("https://www.weatherapi.com/api-explorer")
       .build()



}