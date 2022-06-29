package com.example.nearestridemap.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nearestridemap.Model.RidesItem
import com.example.nearestridemap.R

class MapDataAdapter(val context: Context,val datalist:List<RidesItem>):
    RecyclerView.Adapter<MapDataAdapter.DataHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.map_details_layout,parent,false)
        return DataHolder(view)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val data=datalist[position]
        Glide.with(context).load(data.map_url).into(holder.image)
        holder.city.text=data.city
        holder.date.text=data.date
        holder.distance.text=data.destination_station_code.toString()
        holder.state.text=data.state
        holder.origin_station.text=data.origin_station_code.toString()
        holder.ride_id.text=data.id.toString()
        holder.station_path.text=data.station_path.toString()

    }

    override fun getItemCount()=datalist.size
    class DataHolder(itemview:View):RecyclerView.ViewHolder(itemview)
    {
        val image=itemview.findViewById<ImageView>(R.id.image)
        val city:TextView=itemview.findViewById(R.id.city)
        val state:TextView=itemview.findViewById(R.id.state)
        val ride_id:TextView=itemview.findViewById(R.id.ride_id)
        val origin_station:TextView=itemview.findViewById(R.id.origin)
        val station_path:TextView=itemview.findViewById(R.id.path_station)
        val date:TextView=itemview.findViewById(R.id.date)
        val distance:TextView=itemview.findViewById(R.id.distance)

    }
}