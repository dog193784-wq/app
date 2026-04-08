package com.carelink.app.domain.usecase

import com.carelink.app.domain.model.DeliveryChannel
import com.carelink.app.domain.model.ReportType
import com.carelink.app.domain.repository.*
import javax.inject.Inject

class SyncHealthDataUseCase @Inject constructor(private val repo: HealthDataRepository) {
    suspend operator fun invoke(parentId: String) = repo.sync(parentId)
}
class GenerateReportUseCase @Inject constructor(private val repo: ReportRepository) {
    suspend operator fun invoke(parentId: String, type: ReportType) = repo.generate(parentId, type)
}
class SendReportUseCase @Inject constructor(private val repo: DeliveryRepository) {
    suspend operator fun invoke(channel: DeliveryChannel, payload: String, recipients: List<String>) = repo.send(channel, payload, recipients)
}
class EvaluateAlertsUseCase @Inject constructor(private val repo: AlertRepository) {
    suspend operator fun invoke(parentId: String) = repo.evaluate(parentId)
}
class SendEmergencyAlertUseCase @Inject constructor(private val repo: DeliveryRepository) {
    suspend operator fun invoke(payload: String, recipients: List<String>) = repo.send(DeliveryChannel.BOTH, payload, recipients)
}
class GetHealthHistoryUseCase @Inject constructor(private val repo: HealthDataRepository)
