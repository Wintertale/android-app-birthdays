package com.example.events.ui.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.events.R
import com.example.events.core.models.EventEntity

class MainEventsRecyclerViewAdapter (private val datesList: List<EventEntity>) :
    RecyclerView.Adapter<MainEventsRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val descriptionTextView: TextView
        val dateTextView: TextView

        init {
            // TODO: Define click listener for the ViewHolder's View.
            descriptionTextView = view.findViewById(R.id.datesItemDescriptionTextView)
            dateTextView = view.findViewById(R.id.datesItemDateTextView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.dates_recycler_view_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.descriptionTextView.text = datesList[position].description
        viewHolder.dateTextView.text = datesList[position].getDate().toString()
    }

    // Return the size of the dataset (invoked by the layout manager)
    override fun getItemCount() = datesList.size
}