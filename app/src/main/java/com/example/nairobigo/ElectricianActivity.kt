package com.example.nairobigo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ElectricianActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_electrician)

        // Handle window insets for edge-to-edge support
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up the button click listener for booking
        val buttonBook = findViewById<Button>(R.id.button_electrician) // Change this ID to your booking button ID
        buttonBook.setOnClickListener {
            // Start the BookingDetailsActivity when the book button is clicked
            startActivity(Intent(this, BookingDetailsActivityElectrician::class.java))
        }
    }
}