package com.example.nairobigo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.button_start)

        startButton.setOnClickListener {
            // Start the MainFunctionalityActivity
            val intent = Intent(this, MainFunctionalityActivity::class.java)
            startActivity(intent)
        }
    }
}