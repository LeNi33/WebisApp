package com.example.webisapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.webisapp.model.Plant
import com.example.webisapp.viewmodel.PlantViewModel

class AddPlantActivity : AppCompatActivity() {

    private val viewModel: PlantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plant)

        val etName = findViewById<EditText>(R.id.etName)
        val etDescription = findViewById<EditText>(R.id.etDescription)
        val etWatering = findViewById<EditText>(R.id.etWatering)
        val btnSave = findViewById<Button>(R.id.btnSavePlant)

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val description = etDescription.text.toString()
            val watering = etWatering.text.toString()

            if (name.isEmpty() || watering.isEmpty()) {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val plant = Plant(
                id = 0,
                name = name,
                description = description,
                watering = watering.toInt() // ✅ ahora sí un Int
            )

            viewModel.addPlant(plant)
            Toast.makeText(this, "Planta registrada!", Toast.LENGTH_SHORT).show()
            finish()

        }
    }
}
