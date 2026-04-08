package com.carelink.app.domain.repository

import com.carelink.app.domain.model.*
import kotlinx.coroutines.flow.Flow

interface HealthDataRepository {
    suspend fun sync(parentId: String): Result<Unit>
    fun latestMetrics(parentId: String): Flow<List<HealthData>>
}

interface AlertRepository {
    suspend fun evaluate(parentId: String): Result<List<AlertRule>>
}

interface ReportRepository {
    suspend fun generate(parentId: String, reportType: ReportType): Result<String>
}

interface DeliveryRepository {
    suspend fun send(channel: DeliveryChannel, payload: String, recipients: List<String>): Result<Unit>
}
