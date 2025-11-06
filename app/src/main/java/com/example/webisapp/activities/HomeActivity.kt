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

        // 🔹 Configurar el RecyclerView con las 9 plantas del catálogo
        val adapter = PlantCatalogAdapter(PlantCatalog.plants) { plant ->
            // Ahora al presionar una tarjeta, solo muestra detalles (sin volver al home)
            val intent = Intent(this, PlantDetailActivity::class.java)
            intent.putExtra("nameCommon", plant.nameCommon)
            intent.putExtra("nameScientific", plant.nameScientific)
            intent.putExtra("description", plant.description)
            intent.putExtra("watering", plant.watering)
            intent.putExtra("season", plant.season)
            intent.putExtra("imageResId", plant.imageResId)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        binding.recyclerCatalog.layoutManager = GridLayoutManager(this, 3)
        binding.recyclerCatalog.adapter = adapter

        // 🔹 Botón para ir al CRUD
        binding.btnMyPlants.setOnClickListener {
            startActivity(Intent(this, PlantsActivity::class.java))
        }

        // 🔹 Botón para ir al Login
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
