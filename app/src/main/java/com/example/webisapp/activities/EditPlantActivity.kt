package com.example.webisapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.webisapp.model.Plant
import com.example.webisapp.viewmodel.PlantViewModel

class EditPlantActivity : AppCompatActivity() {

    private val viewModel: PlantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_plant)

        val etName = findViewById<EditText>(R.id.etName)
        val etDescription = findViewById<EditText>(R.id.etDescription)
        val etWatering = findViewById<EditText>(R.id.etWatering)
        val btnSave = findViewById<Button>(R.id.btnSavePlant)

        // ✅ Recibir datos del intent
        val id = intent.getIntExtra("id", -1)
        val name = intent.getStringExtra("name") ?: ""
        val description = intent.getStringExtra("description") ?: ""
        val watering = intent.getStringExtra("watering") ?: ""

        // ✅ Si el ID no existe, salir
        if (id == -1) {
            Toast.makeText(this, "Error al cargar planta", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        // ✅ Llenar campos
        etName.setText(name)
        etDescription.setText(description)
        etWatering.setText(watering)

        btnSave.text = "Actualizar planta"

        btnSave.setOnClickListener {
            val updatedPlant = Plant(
                id = id,
                name = etName.text.toString(),
                description = etDescription.text.toString(),
                watering = etWatering.text.toString().toInt()
            )

            viewModel.updatePlant(updatedPlant)
            Toast.makeText(this, "Planta actualizada ✅", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
