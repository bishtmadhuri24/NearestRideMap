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
import com.example.nearestridemap.Model.Rides
import com.example.nearestridemap.Model.RidesItem
import com.example.nearestridemap.R
import kotlinx.android.synthetic.main.fragment_nearest.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Nearest.newInstance] factory method to
 * create an instance of this fragment.
 */
class Nearest : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var adapter:MapDataAdapter
    lateinit var recycler: RecyclerView

    var datalist= mutableListOf<RidesItem>()
    val baseurl= "https://assessment.api.vweb.app/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view= inflater.inflate(R.layout.fragment_nearest, container, false )
        recycler=view.findViewById(R.id.recycler)
        getMyData()
        return view



    }

    private fun getMyData() {

       recycler.layoutManager=LinearLayoutManager(context)
        recycler.setHasFixedSize(true)
        val retrofit=Retrofit.Builder()
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