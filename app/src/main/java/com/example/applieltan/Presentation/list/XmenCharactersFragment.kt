package com.example.applieltan.Presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applieltan.Presentation.Singletons
import com.example.applieltan.Presentation.api.XmenApi
import com.example.applieltan.Presentation.api.XmenCharactersResponse
import com.example.applieltan.R
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

    private val adapter = XmenAdapter(listOf(), ::onClickedXmen)

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
            layoutManager = LinearLayoutManager(context)
            adapter = this@XmenCharactersFragment.adapter
        }


        Singletons.xmenApi.getXmenList().enqueue(object: Callback<XmenCharactersResponse>{
            override fun onFailure(call: Call<XmenCharactersResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<XmenCharactersResponse>, response: Response<XmenCharactersResponse>) {
                if(response.isSuccessful && response.body() != null){
                    val xmenResponse : XmenCharactersResponse = response.body()!!
                    adapter.updateList(xmenResponse.results)
                }
            }

        })


    }

    private fun onClickedXmen(id: Int) {
        findNavController().navigate(R.id.navigateToXmenDetailFragment, bundleOf(
                "xmenId" to (id + 1)
        ))
    }
}