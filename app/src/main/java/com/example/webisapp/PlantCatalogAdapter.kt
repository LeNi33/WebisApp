package com.example.webisapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.example.webisapp.databinding.ItemCatalogPlantBinding
import com.example.webisapp.model.CatalogPlant

class PlantCatalogAdapter(
    private val plants: List<CatalogPlant>,
    private val onClick: (CatalogPlant) -> Unit
) : RecyclerView.Adapter<PlantCatalogAdapter.PlantViewHolder>() {

    inner class PlantViewHolder(val binding: ItemCatalogPlantBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val binding = ItemCatalogPlantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val plant = plants[position]

        holder.binding.txtCommonName.text = plant.nameCommon
        holder.binding.txtScientificName.text = plant.nameScientific
        holder.binding.imgPlant.setImageResource(plant.imageResId)

        // 🌿 Animación sutil de entrada
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.item_fade_in)
        holder.itemView.startAnimation(animation)

        holder.itemView.setOnClickListener { onClick(plant) }
    }

    override fun getItemCount() = plants.size
}
