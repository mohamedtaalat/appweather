package com.example.msptask5.RecyclerView

import retrofit2.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.msptask5.ApiPackage.Current
import com.example.msptask5.R


 class RecyclerViewAdapter(var weather  : List<Current>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    
    inner class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
         var Raining:TextView=itemview.findViewById(R.id.RainingTv)
         var Temperatue:TextView=itemview.findViewById(R.id.TempTv)
         var Winding:TextView=itemview.findViewById(R.id.WindTv)
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         var view= LayoutInflater.from(parent.context).inflate(R.layout.iteminrec,parent,false)
         return ViewHolder(view)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.Raining.text=weather.get(position).cloud.toString()
         holder.Temperatue.text=weather.get(position).temp_c.toString()
         holder.Winding.text=weather.get(position).wind_kph.toString()
     }

     override fun getItemCount(): Int {
        return weather.size
     }
 }