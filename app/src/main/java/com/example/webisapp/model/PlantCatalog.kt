package com.example.webisapp.model
import com.example.webisapp.R


data class CatalogPlant(
    val nameCommon: String,
    val nameScientific: String,
    val description: String,
    val watering: String,
    val season: String,
    val imageResId: Int
)

object PlantCatalog {


    val plants = listOf(
        CatalogPlant("Guisantes","Pisum sativum","Los guisantes son plantas trepadoras anuales que producen vainas comestibles con semillas ricas en proteínas. Son fáciles de cultivar y mejoran el suelo al fijar nitrógeno.","Riego moderado, manteniendo el sustrato ligeramente húmedo sin encharcar.","Se siembran en primavera o finales de invierno, prefieren climas templados.",R.drawable.guisantes),
        CatalogPlant( "Girasol","Helianthus annuus","El girasol es una planta anual conocida por seguir la trayectoria del sol. Produce grandes flores amarillas y semillas comestibles ricas en aceites saludables.","Riego frecuente pero sin exceso; mantener el suelo húmedo especialmente durante la floración.","Se siembra en primavera y florece en verano, prefiriendo climas cálidos y soleados.",R.drawable.girasol),
        CatalogPlant("Venus-Atrapamoscas", "Dionaea muscipula", "La Venus atrapamoscas es una planta carnívora famosa por sus hojas en forma de trampa que se cierran rápidamente al detectar el contacto de un insecto. Se alimenta de pequeños insectos para complementar los nutrientes que no obtiene del suelo.", "Usar agua destilada o de lluvia. Mantener el sustrato constantemente húmedo pero no encharcado.", "Crece activamente en primavera y verano; entra en reposo durante el invierno.", R.drawable.venus),
        CatalogPlant("Nenúfar", "Nymphaea alba", "El nenúfar es una planta acuática de hojas redondeadas que flotan en la superficie del agua. Sus flores grandes y fragantes pueden ser blancas, rosadas o amarillas, y se abren durante el día.", "No requiere riego tradicional, ya que crece en estanques o cuerpos de agua con una profundidad de 20 a 60 cm.", "Florece en primavera y verano, prefiriendo climas cálidos y soleados.", R.drawable.nenufar),
        CatalogPlant("Cactus", "Cactaceae", "Los cactus son plantas suculentas adaptadas a climas áridos. Almacenan agua en sus tallos y presentan espinas que reducen la pérdida de humedad y protegen de los herbívoros.", "Riego muy escaso. Permitir que la tierra se seque completamente entre riegos. En invierno casi no necesitan agua.", "Crecen mejor en primavera y verano con abundante luz solar y temperaturas cálidas.", R.drawable.cactus),
        CatalogPlant("Nuez-Nogal", "Juglans regia", "El nogal es un árbol caducifolio que produce el fruto conocido como nuez, rico en grasas saludables, proteínas y minerales. Es una especie longeva y de gran tamaño, muy valorada por su madera y sus frutos.", "Requiere riego regular en épocas secas, especialmente durante los primeros años de crecimiento. Evitar el encharcamiento.", "Se planta en otoño o invierno y produce frutos en otoño, prefiriendo climas templados.", R.drawable.nogal),
        CatalogPlant("Maíz", "Zea mays", "El maíz es una planta gramínea cultivada en todo el mundo por sus granos, que son base de la alimentación humana y animal. Es una planta anual de tallo alto y hojas alargadas.", "Requiere riego frecuente durante la germinación y el crecimiento, manteniendo el suelo húmedo pero sin encharcar.", "Se siembra en primavera y se cosecha en verano u otoño, según el clima.", R.drawable.maiz),
        CatalogPlant("Sandía", "Citrullus lanatus", "La sandía es una planta rastrera de la familia de las cucurbitáceas que produce un fruto grande, jugoso y dulce. Es rica en agua, vitaminas y minerales, ideal para climas cálidos.", "Riego abundante y regular, especialmente durante la formación del fruto. Evitar mojar las hojas para prevenir enfermedades.", "Se cultiva en primavera y verano, prosperando en climas cálidos y soleados.", R.drawable.sandia),
        CatalogPlant("Papa", "Solanum tuberosum", "La papa es una planta herbácea perenne cultivada por sus tubérculos comestibles, ricos en carbohidratos, vitaminas y minerales. Es una de las bases alimenticias más importantes del mundo.", "Riego regular, manteniendo el suelo húmedo pero no encharcado. Reducir el riego cuando las hojas empiecen a secarse antes de la cosecha.", "Se planta a fines del invierno o en primavera y se cosecha a finales de verano u otoño, según el clima.", R.drawable.papa)
    )
}
