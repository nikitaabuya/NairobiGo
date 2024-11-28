package com.example.nairobigo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

// Data class to represent a job opportunity
data class JobOpportunity(
    var contractorType: String? = null,
    var date: String? = null,
    var location: String? = null,
    var payment: String? = null,
    var hours: String? = null
)

class ContractorActivity : AppCompatActivity() {

    private lateinit var contractorSpinner: Spinner
    private lateinit var dateEditText: EditText
    private lateinit var locationEditText: EditText
    private lateinit var paymentEditText: EditText
    private lateinit var hoursEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contractor)

        // Initialize views
        contractorSpinner = findViewById(R.id.spinner_contractors)
        dateEditText = findViewById(R.id.edit_text_date)
        locationEditText = findViewById(R.id.edit_text_location)
        paymentEditText = findViewById(R.id.edit_text_payment)
        hoursEditText = findViewById(R.id.edit_text_hours)
        submitButton = findViewById(R.id.button_submit)

        // Set up Firebase Database reference
        database = FirebaseDatabase.getInstance().getReference("opportunities")

        // Set up the dropdown menu
        val contractorTypes = arrayOf("Nanny", "Painter", "HVAC Technician", "Electrician", "House Cleaner", "Plumber")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, contractorTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        contractorSpinner.adapter = adapter

        contractorSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                // Handle selection if needed
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle case when nothing is selected
            }
        }

        submitButton.setOnClickListener {
            val selectedContractor = contractorSpinner.selectedItem.toString()
            val date = dateEditText.text.toString()
            val location = locationEditText.text.toString()
            val payment = paymentEditText.text.toString()
            val hours = hoursEditText.text.toString()

            // Validate input
            if (date.isEmpty() || location.isEmpty() || payment.isEmpty() || hours.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Create a JobOpportunity object
                val jobOpportunity = JobOpportunity(selectedContractor, date, location, payment, hours)

                // Generate a unique key for the new opportunity
                val opportunityId = database.push().key

                if (opportunityId != null) {
                    // Save the job opportunity under the unique key
                    database.child(opportunityId).setValue(jobOpportunity)
                        .addOnSuccessListener {
                            Toast.makeText(this, "Job opportunity submitted successfully!", Toast.LENGTH_SHORT).show()
                            // Optionally clear the fields after submission
                            dateEditText.text.clear()
                            locationEditText.text.clear()
                            paymentEditText.text.clear()
                            hoursEditText.text.clear()
                        }
                        .addOnFailureListener { e ->
                            Toast.makeText(this, "Failed to submit job opportunity: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                }
            }
        }
    }
}