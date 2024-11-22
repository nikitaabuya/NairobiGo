package com.example.nairobigo

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
        setContentView(R.layout.activity_main_functionality)

        val bookButton = findViewById<Button>(R.id.button_book)
        val postButton = findViewById<Button>(R.id.button_post)
        val countTextView = findViewById<TextView>(R.id.textview_choose)

        bookButton.setOnClickListener {
            Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show()
        }

        postButton.setOnClickListener {
            count++
            countTextView.text = count.toString()
        }
    }
}