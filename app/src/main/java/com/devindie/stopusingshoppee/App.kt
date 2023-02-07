package com.devindie.stopusingshoppee

import android.app.Application
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

class App : Application() {

    private val workManager by lazy {
        WorkManager.getInstance(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        createPeriodicWorkRequest()
    }

    private fun createPeriodicWorkRequest() {
        // 1
        val imageWorker = PeriodicWorkRequestBuilder<CheckUsingShopeeWorker>(
            10, TimeUnit.SECONDS)
            .build()
        // 2
        workManager.enqueueUniquePeriodicWork(
            "periodicImageDownload",
            ExistingPeriodicWorkPolicy.KEEP,
            imageWorker
        )
//        observeWork(imageWorker.id)
    }

//    private fun observeWork(id: UUID) {
//        // 1
//        workManager.getWorkInfoByIdLiveData(id)
//            .observe(this, { info ->
//                // 2
//                if (info != null && info.state.isFinished) {
//                    hideLottieAnimation()
//                    activityHomeBinding.downloadLayout.visibility = View.VISIBLE
//                    // 3
//                    val uriResult = info.outputData.getString("IMAGE_URI")
//                    if (uriResult != null) {
//                        showDownloadedImage(uriResult.toUri())
//                    }
//                }
//            })
//    }

}