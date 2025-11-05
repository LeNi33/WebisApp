package com.example.webisapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.webisapp.databinding.ActivityPlantsBinding
import com.example.webisapp.model.Plant
import com.example.webisapp.viewmodel.PlantViewModel

class PlantsActivity : AppCompatActivity() {

    private val viewModel: PlantViewModel by viewModels()
    private lateinit var adapter: PlantsAdapter
    private lateinit var binding: ActivityPlantsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlantsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = PlantsAdapter(
            plants = emptyList(),
            onEditClick = { plant ->
                val intent = Intent(this, EditPlantActivity::class.java)
                intent.putExtra("id", plant.id)
                intent.putExtra("name", plant.name)
                intent.putExtra("description", plant.description)
                intent.putExtra("watering", plant.watering)
                startActivity(intent)
            },
            onDeleteClick = { plant ->
                viewModel.deletePlant(plant)
                Toast.makeText(this, "Planta eliminada", Toast.LENGTH_SHORT).show()
            }
        )

        binding.recyclerPlants.layoutManager = LinearLayoutManager(this)
        binding.recyclerPlants.adapter = adapter

        viewModel.plants.observe(this) {
            adapter.updateData(it)
        }

        binding.btnAddPlant.setOnClickListener {
            startActivity(Intent(this, AddPlantActivity::class.java))
        }
    }
}



