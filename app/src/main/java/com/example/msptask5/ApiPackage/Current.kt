package com.example.msptask5.ApiPackage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["Countryname"],
    unique = true)],tableName = "WeatherDatabase")
data class Current(
    val cloud: Int,
    @Ignore
    val condition: Condition,
    @Ignore
    val feelslike_c: Double,
    @Ignore
    val feelslike_f: Double,
    @Ignore
    val gust_kph: Double,
    @Ignore
    val gust_mph: Double,
    @Ignore
    val humidity: Int,
    @Ignore
    val is_day: Int,
    @Ignore
    val last_updated: String,
    @Ignore
    val last_updated_epoch: Int,
    @Ignore
    val precip_in: Double,
    @Ignore
    val precip_mm: Double,
    @Ignore
    val pressure_in: Double,
    @Ignore
    val pressure_mb: Double,

    @PrimaryKey()
    val temp_c: Double,
    @Ignore
    val temp_f: Double,
    @Ignore
    val uv: Double,
    @Ignore
    val vis_km: Double,
    @Ignore
    val vis_miles: Double,
    @Ignore
    val wind_degree: Int,
    @Ignore
    val wind_dir: String,
    val wind_kph: Double,
    @Ignore
    val wind_mph: Double,
    @ColumnInfo(name="Countyname")
    val CountryName:String
)