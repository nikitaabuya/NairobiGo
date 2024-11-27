package com.example.nairobigo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_client)

        // Handle window insets for edge-to-edge support
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find buttons by their IDs
        val buttonCleaner = findViewById<Button>(R.id.button_cleaner)
        val buttonPlumber = findViewById<Button>(R.id.button_plumber)
        val buttonNanny = findViewById<Button>(R.id.button_nanny)
        val buttonElectrician = findViewById<Button>(R.id.button_electrician)
        val buttonPainter = findViewById<Button>(R.id.button_painter)
        val buttonTechnician = findViewById<Button>(R.id.button_technician)

        // Set up click listeners for each button
        buttonCleaner.setOnClickListener {
            startActivity(Intent(this, HouseCleanerActivity::class.java))
        }

        buttonPlumber.setOnClickListener {
            startActivity(Intent(this, PlumberActivity::class.java))
        }

        buttonNanny.setOnClickListener {
            startActivity(Intent(this, NannyActivity::class.java))
        }

        buttonElectrician.setOnClickListener {
            startActivity(Intent(this, ElectricianActivity::class.java))
        }

        buttonPainter.setOnClickListener {
            startActivity(Intent(this, PainterActivity::class.java))
        }

        buttonTechnician.setOnClickListener {
            startActivity(Intent(this, TechnicianActivity::class.java))
        }
    }
}