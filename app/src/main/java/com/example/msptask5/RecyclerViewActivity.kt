package com.example.msptask5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.msptask5.ApiPackage.ApiKey
import com.example.msptask5.ApiPackage.BuildApi
import com.example.msptask5.ApiPackage.Current
import com.example.msptask5.Data.BuildDatabase
import com.example.msptask5.Data.Repo
import com.example.msptask5.RecyclerView.RecyclerViewAdapter
import com.google.android.material.snackbar.Snackbar
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var Temperature:TextView
    lateinit var Wind:TextView
    lateinit var Raining:TextView
    lateinit var Recyclerview:RecyclerView
    var CountryName = getIntent().getStringExtra("mohamed",)
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
        BuildApi.api.GetApi(ApiKey.apiKey.toString(),CountryName.toString()).enqueue(object : Callback<Current?>{
            override fun onResponse(call: retrofit2.Call<Current?>, response: Response<Current?>) {
                Toast.makeText(this@RecyclerViewActivity, "Success", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: retrofit2.Call<Current?>, t: Throwable) {
                Snackbar.make(Raining,"Fail",Snackbar.LENGTH_SHORT).show()
            }
        })



}

    private fun RecyclerView() {
        var adapter = RecyclerViewAdapter(repo.selectWeatherFromCountryName(CountryName.toString()))
        Recyclerview.adapter = adapter
        Recyclerview.layoutManager = LinearLayoutManager(this)
    }

    private fun Intlization() {
        Temperature = findViewById(R.id.TempTv)
        Raining = findViewById(R.id.RainingTv)
        Wind = findViewById(R.id.WindTv)
    }
}
//lifecycleScope.launchWhenCreated {
 //   val response=try {
 //       BuildApi.api.GetApi(ApiKey.apiKey.toString(),CountryName.toString())

  //  }
  //  catch (e:IOException){
  //      Snackbar.make(Temperature,"Not Internet",Snackbar.LENGTH_SHORT).show()
   //     return@launchWhenCreated
 //   }
 //   catch(e:HttpException) {
 //       Snackbar.make(Temperature,"In known eror",Snackbar.LENGTH_SHORT).show()
 //       return@launchWhenCreated
  //  }


//}
