package com.carelink.app.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.carelink.app.service.AlertEvaluationWorker
import com.carelink.app.service.ReportSchedulerWorker
import java.util.concurrent.TimeUnit

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Intent.ACTION_BOOT_COMPLETED) return
        WorkManager.getInstance(context).enqueueUniquePeriodicWork("report_scheduler", ExistingPeriodicWorkPolicy.KEEP, PeriodicWorkRequestBuilder<ReportSchedulerWorker>(15, TimeUnit.MINUTES).build())
        WorkManager.getInstance(context).enqueueUniquePeriodicWork("alert_evaluation", ExistingPeriodicWorkPolicy.KEEP, PeriodicWorkRequestBuilder<AlertEvaluationWorker>(15, TimeUnit.MINUTES).build())
    }
}
