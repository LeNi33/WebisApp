package com.example.webisapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.webisapp.databinding.ActivityHomeBinding
import com.example.webisapp.model.PlantCatalog

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 🔹 Configuración del catálogo con fotos
        val adapter = PlantCatalogAdapter(PlantCatalog.plants) { plant ->
            val intent = Intent(this, PlantDetailActivity::class.java).apply {
                putExtra("nameCommon", plant.nameCommon)
                putExtra("nameScientific", plant.nameScientific)
                putExtra("description", plant.description)
                putExtra("watering", plant.watering)
                putExtra("season", plant.season)
                putExtra("imageResId", plant.imageResId)
            }
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        binding.recyclerCatalog.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerCatalog.adapter = adapter

        // 🔹 Botón para abrir la pantalla del CRUD (Mis Plantas)
        binding.btnMyPlants.setOnClickListener {
            val intent = Intent(this, PlantsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }

        // 🔹 Botón para abrir la pantalla de Login
        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}
