package com.example.webisapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnPlants = findViewById<Button>(R.id.btnPlants)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnPlants.setOnClickListener {
            startActivity(Intent(this, PlantsActivity::class.java))
        }

        btnLogout.setOnClickListener {
        }
    }
}
