package com.android.uccstudent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.net.toUri
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EmailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_email, container, false)

        val subjectEditText = view.findViewById<EditText>(R.id.subject)
        val recipientEditText = view.findViewById<EditText>(R.id.recipient)
        val bodyEditText = view.findViewById<EditText>(R.id.body)

        view.findViewById<Button>(R.id.sendBtn).setOnClickListener{

            val subject = subjectEditText.text.toString()
            val recipient = recipientEditText.text.toString()
            val body = bodyEditText.text.toString()

            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.data = Uri.parse("mailto:")
            emailIntent.type = "text/plain"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            emailIntent.putExtra(Intent.EXTRA_TEXT, body)

            try {
                startActivity(Intent.createChooser(emailIntent, "send email"))
            }catch (e: Exception){
                Toast.makeText(context, e.message, Toast.LENGTH_LONG).show()
            }
        }

        return view
    }

}

