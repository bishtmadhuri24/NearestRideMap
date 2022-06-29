package com.example.nearestridemap.Api

import com.example.nearestridemap.Model.Rides
import com.example.nearestridemap.Model.RidesItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiNetwork {
    @GET("rides")
    fun getData():Call<List<RidesItem>>

}