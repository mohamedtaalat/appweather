package com.example.msptask5.Data

import androidx.room.Delete
import com.example.msptask5.ApiPackage.ApiKey
import com.example.msptask5.ApiPackage.BuildApi
import com.example.msptask5.ApiPackage.Current
import com.example.msptask5.ApiPackage.WeatherInterface

class Repo(private val dao:Dao) {
    fun GetAll():List<Current>{
      return  dao.GetAll()
    }
    fun GetTemperatureWithCountry(countryName:String):String{
        return dao.GetTemperatureWithCountry(countryName)
    }
    fun GetRainingWithCountry(countryName:String):String{
        return dao.GetRainWithCountry(countryName)
    }
    fun GetwindWithCountry(countryName:String):String{
        return dao.GetWindWithCountry(countryName)
    }
    fun Delete(countryName: String){
        dao.Delete(countryName)
    }
    val Api=BuildApi.api
    fun getWeatherFromApi(apiKey: ApiKey,countryName: String):List<Current>{
        return Api.GetApi(apiKey.toString(),countryName)
    }

    fun addWeather( Weather : List<Current>){
        dao.AddWeather(Weather)


    }
fun selectWeatherFromCountryName(countryName: String):List<Current>{
    return dao.selectWeatherFromCountryName(countryName)
}

}