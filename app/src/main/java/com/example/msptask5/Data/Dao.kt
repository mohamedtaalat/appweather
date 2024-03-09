package com.example.msptask5.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.msptask5.ApiPackage.Current

@Dao
interface Dao {
    @Query("Select* from WeatherDatabase")
    fun GetAll():List<Current>
    @Query("Select temp_c&wind_kph&cloud from WeatherDatabase where Countyname = :countryName  ")
    fun selectWeatherFromCountryName(countryName: String):List<Current>
    @Query("Select temp_c from WeatherDatabase where Countyname = :countryName")
    fun GetTemperatureWithCountry(countryName:String):String
    @Query("Select wind_kph from WeatherDatabase where Countyname = :countryName")
    fun GetWindWithCountry(countryName:String):String
    @Query("Select cloud from WeatherDatabase where Countyname = :countryName")
    fun GetRainWithCountry(countryName:String):String
    @Delete
    fun Delete(countryName: String)
    @Insert
    fun AddWeather(weather:List<Current>)


}