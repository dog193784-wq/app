package com.carelink.app.data.provider

import com.carelink.app.domain.model.HealthData
import com.carelink.app.domain.model.HealthMetric
import javax.inject.Inject

class SamsungHealthProvider @Inject constructor() : HealthDataProvider {
    override suspend fun fetchSince(parentId: String, metric: HealthMetric, sinceEpochMillis: Long): List<HealthData> = emptyList()
}
