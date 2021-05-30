package com.example.applieltan.Presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.applieltan.R

class XmenAdapter(private var dataSet: List<Xmen>, var listener: ((Int)->Unit)? = null) :
    RecyclerView.Adapter<XmenAdapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.xmen_characters)
            imageView = view.findViewById(R.id.xmen_img)
        }
    }

    fun updateList(list: List<Xmen>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.xmen_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val xmen :Xmen = dataSet[position]
        viewHolder.textView.text = xmen.name
        viewHolder.itemView.setOnClickListener {
            listener?.invoke(position)
        }

        Glide
            .with(viewHolder.itemView.context)
            .load("https://cdn.glitch.com/5efd623c-8d1a-4031-846f-78e99ba712ac%2F${position+1}.webp")
            .centerCrop()
            .into(viewHolder.imageView);

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}