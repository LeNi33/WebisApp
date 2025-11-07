package com.example.webisapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat


class PlantNotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val plantName = intent.getStringExtra("plantName") ?: "Planta"

        // ✅ Verificar permiso POST_NOTIFICATIONS
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            val permission = ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.POST_NOTIFICATIONS
            )
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // No se tiene permiso, no se envía notificación
                return
            }
        }

        val builder = NotificationCompat.Builder(context, "plant_channel")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Recordatorio de plantas 🌱")
            .setContentText("No olvides regar tu $plantName hoy")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        NotificationManagerCompat.from(context).notify(plantName.hashCode(), builder.build())
    }
}