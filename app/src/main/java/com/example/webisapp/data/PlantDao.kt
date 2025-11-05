package com.example.webisapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.webisapp.model.Plant

@Dao
interface PlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlant(plant: Plant)

    @Query("SELECT * FROM plant_table ORDER BY id DESC")
    fun getAllPlants(): LiveData<List<Plant>>

    @Update
    suspend fun updatePlant(plant: Plant)

    @Delete
    suspend fun deletePlant(plant: Plant)
}

