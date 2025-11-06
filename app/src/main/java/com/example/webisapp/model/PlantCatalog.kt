package com.example.webisapp.model
import com.example.webisapp.R


data class CatalogPlant(
    val nameCommon: String,
    val nameScientific: String,
    val description: String,
    val watering: String,
    val season: String,
    val imageResId: Int // aquí se guarda el recurso de imagen (R.drawable.xxx)
)

object PlantCatalog {

    // 🔹 Aquí defines tus 9 plantas fijas
    val plants = listOf(
        CatalogPlant(
            nameCommon = "Lavanda",
            nameScientific = "Lavandula angustifolia",
            description = "Planta aromática ideal para climas templados.",
            watering = "Cada 3 días",
            season = "Primavera - Verano",
            imageResId = R.drawable.lavanda // ← Aquí pondrás tu imagen
        ),
        CatalogPlant(
            nameCommon = "Aloe Vera",
            nameScientific = "Aloe barbadensis miller",
            description = "Planta suculenta con propiedades curativas.",
            watering = "Cada 7 días",
            season = "Todo el año",
            imageResId = R.drawable.aloe_vera // ← Aquí pondrás tu imagen
        ),
        // Agrega 7 más con el mismo formato 👇
        CatalogPlant("Menta", "Mentha spicata", "Ideal para infusiones.", "Cada 2 días", "Primavera", R.drawable.menta),
        CatalogPlant("Romero", "Rosmarinus officinalis", "Aromática y medicinal.", "Cada 3 días", "Verano", R.drawable.romero),
        CatalogPlant("Cactus", "Cactaceae", "Muy resistente al calor.", "Cada 15 días", "Verano", R.drawable.cactus),
        CatalogPlant("Helecho", "Pteridophyta", "Prefiere sombra y humedad.", "Cada 2 días", "Otoño", R.drawable.helecho),
        CatalogPlant("Orquídea", "Orchidaceae", "Flores exóticas y delicadas.", "Cada 5 días", "Primavera", R.drawable.orquidea),
        CatalogPlant("Suculenta", "Crassula ovata", "Requiere poca agua.", "Cada 10 días", "Todo el año", R.drawable.suculenta),
        CatalogPlant("Basil", "Ocimum basilicum", "Perfecta para cocina.", "Cada 3 días", "Verano", R.drawable.albahaca)
    )
}
