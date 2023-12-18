package com.example.foodapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        // Phone Communication
        view.findViewById<Button>(R.id.call_button).setOnClickListener {
            val phoneIntent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:+1234567890")
            ) // Replace with actual number
            startActivity(phoneIntent)
        }

        // Email Communication
        view.findViewById<Button>(R.id.email_button).setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:chef@example.com") // Replace with actual email
                putExtra(Intent.EXTRA_SUBJECT, "Inquiry from FoodiePal App")
            }
            if (emailIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(emailIntent)
            }
        }

        return view
    }
}
