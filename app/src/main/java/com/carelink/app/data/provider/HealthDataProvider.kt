package com.carelink.app.data.provider

import com.carelink.app.domain.model.HealthData
import com.carelink.app.domain.model.HealthMetric

interface HealthDataProvider {
    suspend fun fetchSince(parentId: String, metric: HealthMetric, sinceEpochMillis: Long): List<HealthData>
}
