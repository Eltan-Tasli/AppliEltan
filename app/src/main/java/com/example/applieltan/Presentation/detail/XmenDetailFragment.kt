package com.example.applieltan.Presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.applieltan.Presentation.Singletons
import com.example.applieltan.Presentation.api.XmenDetailResponse
import com.example.applieltan.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class XmenDetailFragment : Fragment() {

    private lateinit var textViewName: TextView
    private lateinit var textViewDescription: TextView
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xmen_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.xmen_detail_name)
        textViewDescription = view.findViewById(R.id.xmen_detail_description)
        callApi()
    }

    private fun callApi() {
        val id = arguments?.getInt("xmenId") ?: -1
        Singletons.xmenApi.getXmenDetail(id).enqueue(object : Callback<XmenDetailResponse>{
            override fun onFailure(call: Call<XmenDetailResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<XmenDetailResponse>, response: Response<XmenDetailResponse>) {
                if(response.isSuccessful && response.body() != null){
                    textViewName.text = response.body()!!.name
                    textViewDescription.text = response.body()!!.description
                }

            }

        })
    }
}