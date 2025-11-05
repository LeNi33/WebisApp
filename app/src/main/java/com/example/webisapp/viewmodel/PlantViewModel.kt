package com.example.webisapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.webisapp.data.AppDatabase
import com.example.webisapp.data.PlantRepository
import com.example.webisapp.model.Plant
import kotlinx.coroutines.launch

class PlantViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PlantRepository
    val plants: LiveData<List<Plant>>

    init {
        val plantDao = AppDatabase.getDatabase(application).plantDao()
        repository = PlantRepository(plantDao)
        plants = repository.getAllPlants()
    }

    fun addPlant(plant: Plant) = viewModelScope.launch {
        repository.insertPlant(plant)
    }

    fun updatePlant(plant: Plant) = viewModelScope.launch {
        repository.updatePlant(plant)
    }

    fun deletePlant(plant:Plant) = viewModelScope.launch {
        repository.deletePlant(plant)
    }
}
