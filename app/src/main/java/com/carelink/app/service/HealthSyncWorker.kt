package com.carelink.app.service

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.carelink.app.domain.model.AppResult
import com.carelink.app.domain.usecase.SyncHealthDataUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class HealthSyncWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val syncHealthDataUseCase: SyncHealthDataUseCase,
) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        return when (syncHealthDataUseCase(inputData.getString("parent_id") ?: "default")) {
            is AppResult.Success -> Result.success()
            is AppResult.Loading -> Result.retry()
            is AppResult.Error -> Result.retry()
        }
    }
}
