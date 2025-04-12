package com.android.uccstudent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val fragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()





        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        view.findViewById<ImageView>(R.id.courseImg).setOnClickListener {
            fragmentTransaction.replace(R.id.fragContainer, CoursesFragment()).commit()

        }

        view.findViewById<ImageView>(R.id.socialImage).setOnClickListener {
            fragmentTransaction.replace(R.id.fragContainer, SocialsFragment()).commit()
        }

        view.findViewById<ImageView>(R.id.facultyImage).setOnClickListener {
            fragmentTransaction.replace(R.id.fragContainer, FacultyFragment()).commit()
        }

        view.findViewById<ImageView>(R.id.admissionsImage).setOnClickListener {
            fragmentTransaction.replace(R.id.fragContainer, AdmissionsFragment()).commit()
        }

        return view

    }

}