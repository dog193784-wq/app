package com.carelink.app.domain.repository

import com.carelink.app.domain.model.*
import kotlinx.coroutines.flow.Flow

interface HealthDataRepository {
    suspend fun sync(parentId: String): AppResult<Unit>
    fun latestMetrics(parentId: String): Flow<List<HealthData>>
}

interface AlertRepository {
    suspend fun evaluate(parentId: String): AppResult<List<AlertRule>>
}

interface ReportRepository {
    suspend fun generate(parentId: String, reportType: ReportType): AppResult<String>
}

interface DeliveryRepository {
    suspend fun send(channel: DeliveryChannel, payload: String, recipients: List<String>): AppResult<Unit>
}
