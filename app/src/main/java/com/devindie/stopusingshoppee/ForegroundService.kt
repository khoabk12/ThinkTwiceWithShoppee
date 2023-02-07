package com.devindie.stopusingshoppee

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat


class ForegroundService : Service() {
    override fun onBind(intent: Intent?): IBinder {
        throw UnsupportedOperationException("Not yet implemented")
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

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
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