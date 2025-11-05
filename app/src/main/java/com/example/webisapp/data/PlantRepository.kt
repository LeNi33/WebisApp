package com.example.webisapp.data

import androidx.lifecycle.LiveData
import com.example.webisapp.model.Plant

class PlantRepository(private val plantDao: PlantDao) {

    fun getAllPlants(): LiveData<List<Plant>> = plantDao.getAllPlants()

    suspend fun insertPlant(plant: Plant) =
        plantDao.insertPlant(plant)

    suspend fun updatePlant(plant: Plant) =
        plantDao.updatePlant(plant)

    suspend fun deletePlant(plant: Plant) =
        plantDao.deletePlant(plant)
}
