package com.example.nairobigo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import android.widget.Toast

class BookingDetailsActivityTechnician : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_booking_details_technician)

        database = FirebaseDatabase.getInstance().reference

        // Set up the button click listener
        val buttonSubmit = findViewById<Button>(R.id.button_submit_booking)
        buttonSubmit.setOnClickListener {
            val name = findViewById<EditText>(R.id.edit_text_name).text.toString()
            val location = findViewById<EditText>(R.id.edit_text_location).text.toString()
            val date = findViewById<EditText>(R.id.edit_text_date).text.toString()
            val hours = findViewById<EditText>(R.id.edit_text_hours).text.toString()

            val booking = Booking(name, location, date, hours, "technician")

            // Save to Firebase under the technician node
            database.child("bookings").child("technician").push().setValue(booking)
                .addOnSuccessListener {
                    Toast.makeText(this, "Booking saved successfully!", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed to save booking.", Toast.LENGTH_SHORT).show()
                }
        }
    }

    data class Booking(
        val name: String = "",
        val location: String = "",
        val date: String = "",
        val hours: String = "",
        val serviceType: String = ""
    )
}