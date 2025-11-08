package com.example.webisapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.webisapp.model.CatalogPlant

class PlantCatalogAdapter(
    private val plants: List<CatalogPlant>,
    private val onClick: (CatalogPlant) -> Unit
) : RecyclerView.Adapter<PlantCatalogAdapter.PlantViewHolder>() {

    inner class PlantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPlant: ImageView = itemView.findViewById(R.id.imgPlant)
        val tvCommonName: TextView = itemView.findViewById(R.id.tvCommonName)
        val tvScientificName: TextView = itemView.findViewById(R.id.tvScientificName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_catalog_plant, parent, false)
        return PlantViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = plants[position]
        holder.imgPlant.setImageResource(plant.imageResId)
        holder.tvCommonName.text = plant.nameCommon
        holder.tvScientificName.text = plant.nameScientific


        holder.itemView.setOnClickListener { onClick(plant) }


        holder.itemView.alpha = 0f
        holder.itemView.animate()
            .alpha(1f)
            .setDuration(500)
            .start()
    }

    override fun getItemCount(): Int = plants.size
}
