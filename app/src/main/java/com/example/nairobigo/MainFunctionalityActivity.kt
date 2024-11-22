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

        val toastButton = findViewById<Button>(R.id.button_toast)
        val countButton = findViewById<Button>(R.id.button_count)
        val countTextView = findViewById<TextView>(R.id.textview_count)

        toastButton.setOnClickListener {
            Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show()
        }

        countButton.setOnClickListener {
            count++
            countTextView.text = count.toString()
        }
    }
}