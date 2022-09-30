package com.example.events.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.events.core.models.EventEntity
import com.example.events.databinding.DatesRecyclerViewItemBinding

class MainEventsRecyclerViewAdapter (private val datesList: List<EventEntity>) :
    ListAdapter<EventEntity, MainEventsRecyclerViewAdapter.EventsViewHolder>(DiffCallback()) {

    private lateinit var binding: DatesRecyclerViewItemBinding

    class EventsViewHolder(private val binding: DatesRecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(event :EventEntity) {
            binding.datesItemDescriptionTextView.text = event.description
            binding.datesItemDateTextView.text = event.getDate().toString()
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): EventsViewHolder {
        binding = DatesRecyclerViewItemBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return EventsViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: EventsViewHolder, position: Int) {
        viewHolder.bind(datesList[position])
    }

    // Return the size of the dataset (invoked by the layout manager)
    override fun getItemCount() = datesList.size

    class DiffCallback : DiffUtil.ItemCallback<EventEntity>() {

        override fun areItemsTheSame(oldItem: EventEntity, newItem: EventEntity) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: EventEntity, newItem: EventEntity) =
            oldItem == newItem
    }
}