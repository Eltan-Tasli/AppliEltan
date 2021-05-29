package com.example.applieltan.Presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applieltan.R

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

        val xmenList :ArrayList<Xmen> = arrayListOf<Xmen>().apply {
            add(Xmen("Wolverine"))
            add(Xmen("Xavier"))
            add(Xmen("Cyclope"))
        }

        adapter.updateList(xmenList)


    }
}