package com.android.uccstudent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri

class SocialsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_socials, container, false)
        view.findViewById<ImageView>(R.id.instagramImg).setOnClickListener {
            launchInstaPage("https://www.instagram.com/uccjamaica/?hl=en")
        }

        view.findViewById<ImageView>(R.id.facebookImg).setOnClickListener {
            launchFacebookPage("https://www.facebook.com/uccjamaica/")
        }

        view.findViewById<ImageView>(R.id.twitterImg).setOnClickListener {
            launchTwitterPage("https://x.com/uccjamaica")
        }

        return view
    }

    private fun launchInstaPage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = url.toUri()
        startActivity(intent)
    }

    private fun launchFacebookPage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = url.toUri()
        startActivity(intent)
    }

    private fun launchTwitterPage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = url.toUri()
        startActivity(intent)
    }



}