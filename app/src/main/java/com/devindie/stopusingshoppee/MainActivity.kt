package com.devindie.stopusingshoppee

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.devindie.stopusingshoppee.appusagestatistics.AppUsageStatisticsFragment

class MainActivity : AppCompatActivity() {
    private val REQUEST_CODE = -1010101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Test StatUsageManager
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, AppUsageStatisticsFragment.newInstance())
                .commit()
        }

        //Test Overlay
        checkOverlayPermission()
        startOverlayService()
    }

    private fun startOverlayService() {
        // check if the user has already granted
        // the Draw over other apps permission
        if (Settings.canDrawOverlays(this)) {
            // start the service based on the android version
            startForegroundService(Intent(this, ForegroundService::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        startOverlayService()
    }

    private fun checkOverlayPermission() {
        if (!Settings.canDrawOverlays(this)) {
            // send user to the device settings
            val myIntent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
            startActivity(myIntent)
        }
    }

    private fun checkDrawOverlayPermission() {
        if (Settings.canDrawOverlays(applicationContext)) {
            val intent = Intent(
                Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:" + applicationContext.packageName)
            )
            startActivityForResult(intent, REQUEST_CODE)
        } else {
            disablePullNotificationTouch()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (Settings.canDrawOverlays(this)) {
                    disablePullNotificationTouch()
                }
            }
        }
    }

    private fun disablePullNotificationTouch() {

    }
}