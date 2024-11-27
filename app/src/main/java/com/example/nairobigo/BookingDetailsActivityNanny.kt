package com.example.nairobigo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BookingDetailsActivityNanny : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_booking_details_nanny)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up the button click listener
        val buttonSubmit = findViewById<Button>(R.id.button_submit_booking)
        buttonSubmit.setOnClickListener {
            // Handle the submission of booking details
            // You can retrieve the input fields here
            val name = findViewById<EditText>(R.id.edit_text_name).text.toString()
            val location = findViewById<EditText>(R.id.edit_text_location).text.toString()
            val date = findViewById<EditText>(R.id.edit_text_date).text.toString()
            val hours = findViewById<EditText>(R.id.edit_text_hours).text.toString()

            // Handle the booking details (e.g., saving, sending to server, etc.)
        }
    }
}