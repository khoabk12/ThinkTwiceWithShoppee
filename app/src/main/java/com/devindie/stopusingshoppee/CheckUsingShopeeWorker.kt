package com.devindie.stopusingshoppee

import android.app.usage.UsageStatsManager
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters

class CheckUsingShopeeWorker(
    private val context: Context,
    workerParameters: WorkerParameters
) : Worker(context, workerParameters) {
    private val mUsageStatsManager: UsageStatsManager by lazy { context.getSystemService(Context.USAGE_STATS_SERVICE) as UsageStatsManager }
    override fun doWork(): Result {
        val queryUsageStats = mUsageStatsManager
            .queryUsageStats(
                UsageStatsManager.INTERVAL_DAILY, System.currentTimeMillis() - 20000 * 10,
                System.currentTimeMillis()
            )
        val packageNames = queryUsageStats.map { it.packageName }
        packageNames.forEach {
            Log.e("package Name: ", it)
        }
        return if (packageNames.contains("com.shopee.vn")) {
            Toast.makeText(applicationContext, "SHOW OVERLAY", Toast.LENGTH_SHORT).show()
            Result.success()
        } else {
            Result.failure()
        }
    }
}