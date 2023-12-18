package com.example.foodapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AboutMeFragment : Fragment() {

    private lateinit var aboutMeText: TextView
    private lateinit var fab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about_me, container, false)

        aboutMeText = view.findViewById(R.id.about_me_text)
        fab = view.findViewById(R.id.add_detail_fab)

        loadDetails()

        fab.setOnClickListener {
        }

        return view
    }

    private fun loadDetails() {
        aboutMeText.text = "My Name is Mohammad Kiwan";
    }
}
