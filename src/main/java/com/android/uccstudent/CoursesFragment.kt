package com.android.uccstudent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CoursesFragment : Fragment() {
    private lateinit var courseViewModel: CourseViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_courses, container, false)

        val adapter = CourseAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recylerview)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        courseViewModel = ViewModelProvider(this)[CourseViewModel::class.java]
        courseViewModel.courseData.observe(viewLifecycleOwner) { course ->
            adapter.setData(course)
        }

        return view
    }


}