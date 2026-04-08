package com.carelink.app.data.repository

import com.carelink.app.domain.model.DeliveryChannel
import com.carelink.app.domain.repository.DeliveryRepository
import javax.inject.Inject

class DeliveryRepositoryImpl @Inject constructor() : DeliveryRepository {
    override suspend fun send(channel: DeliveryChannel, payload: String, recipients: List<String>): Result<Unit> = Result.success(Unit)
}
