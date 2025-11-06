package com.example.webisapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webisapp.databinding.ActivityPlantDetailBinding

class PlantDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlantDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlantDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtCommonName.text = intent.getStringExtra("nameCommon")
        binding.txtScientificName.text = intent.getStringExtra("nameScientific")
        binding.txtDescription.text = intent.getStringExtra("description")
        binding.txtWatering.text = intent.getStringExtra("watering")
        binding.txtSeason.text = intent.getStringExtra("season")
        val imageResId = intent.getIntExtra("imageResId", 0)
        if (imageResId != 0) binding.imgPlant.setImageResource(imageResId)
    }
}
