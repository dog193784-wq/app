package com.carelink.app.data.repository

import com.carelink.app.domain.model.AlertRule
import com.carelink.app.domain.repository.AlertRepository
import javax.inject.Inject

class AlertRepositoryImpl @Inject constructor() : AlertRepository {
    override suspend fun evaluate(parentId: String): Result<List<AlertRule>> = Result.success(emptyList())
}
