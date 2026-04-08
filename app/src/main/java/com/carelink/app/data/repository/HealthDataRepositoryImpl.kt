package com.carelink.app.data.repository

import com.carelink.app.data.local.db.dao.HealthDataDao
import com.carelink.app.data.local.db.entity.HealthDataEntity
import com.carelink.app.data.provider.ProviderFactory
import com.carelink.app.domain.model.HealthData
import com.carelink.app.domain.model.HealthMetric
import com.carelink.app.domain.repository.HealthDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class HealthDataRepositoryImpl @Inject constructor(private val dao: HealthDataDao, private val providerFactory: ProviderFactory) : HealthDataRepository {
    override suspend fun sync(parentId: String): Result<Unit> = runCatching {
        val provider = providerFactory.primary()
        val metrics = listOf(HealthMetric.HEART_RATE, HealthMetric.STEPS, HealthMetric.SLEEP, HealthMetric.SPO2, HealthMetric.STRESS, HealthMetric.CALORIES)
        val now = System.currentTimeMillis()
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date(now))
        val entities = metrics.flatMap { m -> provider.fetchSince(parentId, m, now - 60 * 60_000).map { HealthDataEntity(parentId = it.parentId, metricType = it.metric.name, value = it.value, unit = it.unit, timestamp = it.timestamp, date = date) } }
        if (entities.isNotEmpty()) dao.insertAll(entities)
    }

    override fun latestMetrics(parentId: String): Flow<List<HealthData>> = dao.observeByParent(parentId).map { list ->
        list.map { HealthData(it.parentId, HealthMetric.valueOf(it.metricType), it.value, it.unit, it.timestamp) }
    }
}
