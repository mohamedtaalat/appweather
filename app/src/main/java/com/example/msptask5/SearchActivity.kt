package com.example.msptask5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class SearchActivity : AppCompatActivity() {
    lateinit var GoButton:Button
    lateinit var CountryName:EditText
    lateinit var ContackUs:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        inlization()
        var NameOfCountry:String=CountryName.text.toString()
        ContackUs.setOnClickListener{
            val intent=Intent(Intent.ACTION_SEND)
        }
        GoButton.setOnClickListener{
            goButtonBody(NameOfCountry)
        }
    }


    private fun goButtonBody(NameOfCountry: String) {
        if (CountryName.text != null) {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            intent.putExtra("mohamed", NameOfCountry)
            startActivity(intent)
        } else {
            Snackbar.make(GoButton, "country name faild", Snackbar.LENGTH_SHORT).show()
            CountryName.setError("Empty")
        }
    }

    private fun inlization() {
        GoButton = findViewById(R.id.GoBtn)
        CountryName = findViewById(R.id.NameCountyEd)
        ContackUs = findViewById(R.id.ContactUs)
    }
}