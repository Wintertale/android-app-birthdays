package com.example.events.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.events.R
import com.example.events.models.DatesInfo
import com.example.events.databinding.FragmentMainEventsListBinding
import com.example.events.ui.viewmodels.MainEventsListViewModel


class MainEventsListFragment : Fragment() {

    private var _binding: FragmentMainEventsListBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainEventsListBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model: MainEventsListViewModel by viewModels()

        val recyclerView: RecyclerView = binding.mainEventsRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        // Create the observer which updates the UI.
        val datesInfoListObserver = Observer<List<DatesInfo>> { datesInfoList ->
            recyclerView.adapter = MainEventsRecyclerViewAdapter(datesInfoList)
            // update UI
        }
        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.getDatesInfoList().observe(viewLifecycleOwner, datesInfoListObserver)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}