package com.devindie.stopusingshoppee.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat
import com.devindie.stopusingshoppee.ForegroundService

class BootCompletedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            Log.e("RECEIVE BOOT","START FOREGROUND SERVICE NOW")
//            ContextCompat.startForegroundService(it, Intent(it, ForegroundService::class.java))
        }
    }
}