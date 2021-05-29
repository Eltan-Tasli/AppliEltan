package com.example.applieltan.Presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applieltan.Presentation.api.XmenApi
import com.example.applieltan.Presentation.api.XmenResponse
import com.example.applieltan.R
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class XmenCharactersFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val adapter = XmenAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_xmen_characters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.xmen_recyclerview)
        recyclerView.apply {
            layoutManager = this@XmenCharactersFragment.layoutManager
            adapter = this@XmenCharactersFragment.adapter
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://xmenapiheroku.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val xmenApi: XmenApi = retrofit.create(XmenApi::class.java)

        xmenApi.getXmenList().enqueue(object: Callback<XmenResponse>{
            override fun onFailure(call: Call<XmenResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<XmenResponse>, response: Response<XmenResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val xmenResponse : XmenResponse = response.body()!!
                    adapter.updateList(xmenResponse.results)
                }
            }

        })


    }
}