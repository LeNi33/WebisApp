package com.example.webisapp

import android.content.Intent
import android.os.Bundle
import android.net.Uri
import android.view.View
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

        val imageUri = intent.getStringExtra("imageUri")
        val email = intent.getStringExtra("email")


        if (!email.isNullOrEmpty()) {
            binding.btnLogin.visibility = View.GONE
        }

        imageUri?.let {
            binding.imageUserProfile.setImageURI(Uri.parse(it))
        }


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


        binding.btnMyPlants.setOnClickListener {
            val intent = Intent(this, PlantsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }


        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}
