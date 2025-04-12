package com.android.uccstudent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.net.toUri
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FacultyFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_faculty, container, false)

        view.findViewById<Button>(R.id.call1).setOnClickListener {
            val phoneNumber = "tel:8761234567"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = phoneNumber.toUri()
            startActivity(intent)
        }

        view.findViewById<Button>(R.id.call2).setOnClickListener {
            val phoneNumber = "tel:8765678900"
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = phoneNumber.toUri()
            startActivity(intent)

        }

        view.findViewById<FloatingActionButton>(R.id.email_fab).setOnClickListener{

            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.data = Uri.parse("mailto:")
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("msstone@ucc.edu.hod.jm")) // Set email recipient

            try {
                startActivity(Intent.createChooser(emailIntent, "send email"))
            }catch (e: Exception){
                Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
            }
        }

        view.findViewById<FloatingActionButton>(R.id.email_fab2).setOnClickListener{

            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.data = Uri.parse("mailto:")
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("itprogramofficer@ucc.edu.jm")) // Set email recipient

            try {
                startActivity(Intent.createChooser(emailIntent, "send email"))
            }catch (e: Exception){
                Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
            }
        }

        return view
    }

}