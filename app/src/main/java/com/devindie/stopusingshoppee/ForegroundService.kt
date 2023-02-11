package com.devindie.stopusingshoppee

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.app.usage.UsageEvents
import android.app.usage.UsageStatsManager
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import java.lang.System.currentTimeMillis
import java.util.*


class ForegroundService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        // create the custom or default notification
        // based on the android version
        startMyOwnForeground()

        // create an instance of Window class
        // and display the content on screen
//        val window = Window(this)
//        window.open()
//        Toast.makeText(applicationContext, "OVERLAY", Toast.LENGTH_SHORT).show()
    }

    private val systemService: UsageStatsManager by lazy {
        ContextCompat.getSystemService(
            this,
            UsageStatsManager::class.java
        ) as UsageStatsManager
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                logForegroundApps()
            }
        }, 0, 500)
        return START_STICKY
    }

    private fun logForegroundApps() {
        val queryEvents: UsageEvents =
            systemService.queryEvents(currentTimeMillis(), currentTimeMillis() - 10_000 * 10)
        Log.e("has new Event?: ",queryEvents.hasNextEvent().toString())
    }

    // for android version >=O we need to create
    // custom notification stating
    // foreground service is running
    private val NOTIFICATION_CHANNEL_ID = "example.permanence"
    private fun startMyOwnForeground() {

        val channelName = "Background Service"
        val chan = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            channelName,
            NotificationManager.IMPORTANCE_MIN
        )
        val manager =
            (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?)!!
        manager.createNotificationChannel(chan)
        val notificationBuilder: NotificationCompat.Builder =
            NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
        val notification: Notification = notificationBuilder.setOngoing(true)
            .setContentTitle("Service running")
            .setContentText("Displaying over other apps") // this is important, otherwise the notification will show the way
            // you want i.e. it will show some default notification
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setPriority(NotificationManager.IMPORTANCE_MIN)
            .setCategory(Notification.CATEGORY_SERVICE)
            .build()
        startForeground(2, notification)
    }
}