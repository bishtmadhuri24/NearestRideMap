package com.example.nearestridemap.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.nearestridemap.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Filter_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Filter_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var arrayAdapter:ArrayAdapter<CharSequence>
    lateinit var arrayAdapter1:ArrayAdapter<CharSequence>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_filter_, container, false)
        val spinner1:Spinner=view.findViewById(R.id.spinner1)
        val spinner2:Spinner=view.findViewById(R.id.spinner2)
       arrayAdapter= ArrayAdapter.createFromResource(requireContext(),R.array.city,android.R.layout.simple_spinner_item)
        arrayAdapter1= ArrayAdapter.createFromResource(requireContext(),R.array.state,android.R.layout.simple_spinner_item)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner1.adapter=arrayAdapter
        spinner2.adapter=arrayAdapter1
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Filter_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Filter_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}