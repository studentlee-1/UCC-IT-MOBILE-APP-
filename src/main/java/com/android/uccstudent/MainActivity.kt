package com.android.uccstudent

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var courseViewMdl: CourseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        courseViewMdl = ViewModelProvider(this)[CourseViewModel::class.java]

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNav)
        addCourse()
        bottomNav.setOnItemSelectedListener { item ->
            val fragment: Fragment = when(item.itemId){
                R.id.home -> HomeFragment()
                R.id.email -> EmailFragment()
                else -> HomeFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragContainer, fragment).commit()
            true
        }

    }

    override fun onBackPressed() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragContainer)
        if (currentFragment is HomeFragment) {

            super.onBackPressed()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.fragContainer, HomeFragment()).commit()
        }
    }


    private fun addCourse(){
        val courseData = listOf(
            Courses("ITT200", "Object Oriented Programming Using C++",
                "Programming Technique", "C++ is a general-purpose, high-level programming language, " +
                        "created as an extension of the C language"),

            Courses("ITT210", "Database Management Systems",
                "None", "Database management using SQL " +
                        "(Structured Query Language) involves handling, organizing, " +
                        "and accessing data stored in databases in table format"),

            Courses("ITT211", "Computer Data Analsis", "None",
                "Analysis and organization of data using tools such as Python programming" +
                        "Microsoft exel, and Microsoft power BI"),

            Courses("ITT208", "Internet Authoring 1", "None",
                "Front end web development using HTML, CSS and Javascript"),

            Courses("ITT307", "Internet Authoring 2", "Internet Authoring1",
                "Backend web development using PHP and MYSQL database management system"),

            Courses("ITT116","Computer Essentials and Troubleshooting 1", "None",
                "Building, troubleshooting and repairing computer hardware systems and computer networks"),

            Courses("ITT216", "Computer Essentials and Troubleshooting 2",
                "Computer Essentials and Troubleshooting 1",
                "Managing computer operating systems using build in tools and basic network configurations"),
            Courses("ITT101", "Computer Information Systems", "None",
                "This course is an an introductory course about computer systems and network and" +
                        "how the computer distributes information with its varying components"),
            Courses("ITT403", "Data Communications and Network 2", "Data Communications and Network 1",
                "This course goes more indepth about network formatting and components of a network"),
            Courses("ITT215", "Technical Writing for Digital Media", "Academic Writing 1",
                "This course teaches how communication is conducted using varying types of digital media and" +
                        "its importance in today's communication landscape."))

        for (course in courseData){
            courseViewMdl.addCourse(course)

        }

    }

}