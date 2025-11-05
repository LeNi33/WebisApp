package com.example.webisapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.webisapp.databinding.ItemPlantBinding
import com.example.webisapp.model.Plant

class PlantsAdapter(
    private var plants: List<Plant>,
    private val onEditClick: (Plant) -> Unit,
    private val onDeleteClick: (Plant) -> Unit
) : RecyclerView.Adapter<PlantsAdapter.PlantViewHolder>() {

    inner class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvPlantName)
        val tvDescription: TextView = itemView.findViewById(R.id.tvPlantDescription)
        val btnEdit: ImageButton = itemView.findViewById(R.id.btnEdit)
        val btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plant, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = plants[position]
        holder.tvName.text = plant.name
        holder.tvDescription.text = plant.description

        holder.btnEdit.setOnClickListener { onEditClick(plant) }
        holder.btnDelete.setOnClickListener { onDeleteClick(plant) }
    }

    override fun getItemCount(): Int = plants.size

    fun updateData(newPlants: List<Plant>) {
        plants = newPlants
        notifyDataSetChanged()
    }
}




