package com.example.webisapp

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

import android.content.pm.PackageManager
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.example.webisapp.databinding.ActivityPlantDetailBinding
import java.util.*

class PlantDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlantDetailBinding
    private val REQUEST_NOTIFICATION_PERMISSION = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlantDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Crear el canal de notificación (Android 8+)
        createNotificationChannel()

        // Pedir permiso de notificaciones si es Android 13+
        requestNotificationPermissionIfNeeded()

        val plantName = intent.getStringExtra("nameCommon") ?: "Planta"
        val imageResId = intent.getIntExtra("imageResId", 0)

        binding.txtCommonName.text = intent.getStringExtra("nameCommon")
        binding.txtScientificName.text = intent.getStringExtra("nameScientific")
        binding.txtDescription.text = intent.getStringExtra("description")
        binding.txtWatering.text = intent.getStringExtra("watering")
        binding.txtSeason.text = intent.getStringExtra("season")
        if (imageResId != 0) binding.imgPlant.setImageResource(imageResId)

        // Botón para programar notificación diaria
        binding.btnActivateReminder.setOnClickListener {
            scheduleDailyNotification(plantName)
            Toast.makeText(this, "Recordatorio activado ✅", Toast.LENGTH_SHORT).show()
        }

        // Botón de prueba (dispara notificación inmediata)
        binding.btnTestReminder.setOnClickListener {
            sendImmediateNotification(plantName)
        }
    }

    // Crear canal de notificación
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Recordatorios de plantas"
            val descriptionText = "Canal para recordatorios diarios de plantas"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("plant_channel", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    // Pedir permiso de notificaciones (Android 13+)
    private fun requestNotificationPermissionIfNeeded() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permissionStatus = ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.POST_NOTIFICATIONS
            )

            if (permissionStatus != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.POST_NOTIFICATIONS),
                    REQUEST_NOTIFICATION_PERMISSION
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_NOTIFICATION_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permiso de notificaciones otorgado ✅", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Permiso de notificaciones denegado ⚠️", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun scheduleDailyNotification(plantName: String) {
        val intent = Intent(this, PlantNotificationReceiver::class.java)
        intent.putExtra("plantName", plantName)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            plantName.hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 9)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            if (before(Calendar.getInstance())) add(Calendar.DAY_OF_MONTH, 1)
        }

        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
    }

    private fun sendImmediateNotification(plantName: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permission = ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.POST_NOTIFICATIONS
            )
            if (permission != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permiso de notificaciones denegado ⚠️", Toast.LENGTH_SHORT).show()
                return
            }
        }

        val builder = NotificationCompat.Builder(this, "plant_channel")
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Recordatorio de plantas 🌱")
            .setContentText("No olvides regar tu $plantName hoy")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            notify(plantName.hashCode(), builder.build())
        }
    }
}
