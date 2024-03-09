package com.example.msptask5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.msptask5.ApiPackage.ApiKey
import com.example.msptask5.ApiPackage.BuildApi
import com.example.msptask5.ApiPackage.Current
import com.example.msptask5.ApiPackage.WeatherInterface
import com.example.msptask5.Data.BuildDatabase
import com.example.msptask5.Data.Repo
import com.example.msptask5.RecyclerView.RecyclerViewAdapter
import com.google.android.material.snackbar.Snackbar

import retrofit2.Callback

import retrofit2.Response



class RecyclerViewActivity : AppCompatActivity() {

    lateinit var Recyclerview:RecyclerView
    var CountryName = getIntent().getStringExtra("mohamed")
    val database:BuildDatabase by lazy{
       BuildDatabase.getDatabase(baseContext)
    }
    lateinit var repo:Repo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerviewactivity)
        repo = Repo(database.dao())
        Intlization()
        RecyclerView()
        BuildApi.api.create(WeatherInterface::class.java).GetApiWeather(ApiKey.apiKey.toString(),CountryName.toString())
            .enqueue(object : Callback<Current?>{
            override fun onResponse(call: retrofit2.Call<Current?>, response: Response<Current?>) {

                if (response.isSuccessful){
                    var weatherList= listOf(response.body()) as List<Current>
                    repo.addWeather(weatherList)
                    Toast.makeText(this@RecyclerViewActivity, "Success", Toast.LENGTH_SHORT).show()
                }else {
                    Snackbar.make(Recyclerview,response.message(),Snackbar.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: retrofit2.Call<Current?>, t: Throwable) {
                Snackbar.make(Recyclerview,"Fail",Snackbar.LENGTH_SHORT).show()
            }
        })



}

    private fun RecyclerView() {
        var adapter = RecyclerViewAdapter(repo.selectWeatherFromCountryName(CountryName.toString()))
        Recyclerview.adapter = adapter
        Recyclerview.layoutManager = LinearLayoutManager(this)
    }

    private fun Intlization() {
      Recyclerview=findViewById(R.id.recyclerView)
    }
}


