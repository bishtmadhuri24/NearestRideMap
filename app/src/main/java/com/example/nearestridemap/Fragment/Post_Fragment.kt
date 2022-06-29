package com.example.nearestridemap.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nearestridemap.Adapter.MapDataAdapter
import com.example.nearestridemap.Api.ApiNetwork
import com.example.nearestridemap.Model.RidesItem
import com.example.nearestridemap.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Post_Fragment : Fragment() {

    lateinit var adapter: MapDataAdapter
    lateinit var recycler: RecyclerView

    var datalist= mutableListOf<RidesItem>()
    val baseurl= "https://assessment.api.vweb.app/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_post_, container, false)
        recycler=view.findViewById(R.id.recycler)
        getMyData()
        return view
    }

    private fun getMyData() {
        recycler.layoutManager= LinearLayoutManager(context)
        recycler.setHasFixedSize(true)
        val retrofit= Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseurl)
            .build()
            .create(ApiNetwork::class.java)
        val dataretro=retrofit.getData()
        dataretro.enqueue(object : Callback<List<RidesItem>?> {
            override fun onResponse(
                call: Call<List<RidesItem>?>,
                response: Response<List<RidesItem>?>
            ) {
                datalist= response.body() as MutableList<RidesItem>
                adapter= MapDataAdapter(requireContext(),datalist)
                recycler.adapter=adapter


            }

            override fun onFailure(call: Call<List<RidesItem>?>, t: Throwable) {
                Log.d("main","error")
            }
        })

    }

}