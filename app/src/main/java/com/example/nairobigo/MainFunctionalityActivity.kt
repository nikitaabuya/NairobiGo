package com.example.nairobigo

import android.content.Intent // Import the Intent class
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainFunctionalityActivity : AppCompatActivity() {
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_functionality)

        val bookButton = findViewById<Button>(R.id.button_book)
        val postButton = findViewById<Button>(R.id.button_post)
        val countTextView = findViewById<TextView>(R.id.textview_choose)

        // Set up click listener for the "Book Contractor" button
        bookButton.setOnClickListener {
            // Start ClientActivity
            val intent = Intent(this, ClientActivity::class.java)
            startActivity(intent)
        }

        // Set up click listener for the "Post Job Opportunity" button
        val buttonPost = findViewById<Button>(R.id.button_post)
        buttonPost.setOnClickListener {
            val intent = Intent(this, ContractorActivity::class.java)
            startActivity(intent)
        }
    }
}