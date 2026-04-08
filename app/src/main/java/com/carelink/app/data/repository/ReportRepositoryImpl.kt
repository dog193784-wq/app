package com.carelink.app.data.repository

import com.carelink.app.domain.model.AppResult
import com.carelink.app.domain.model.ReportType
import com.carelink.app.domain.repository.ReportRepository
import javax.inject.Inject

class ReportRepositoryImpl @Inject constructor() : ReportRepository {
    override suspend fun generate(parentId: String, reportType: ReportType): AppResult<String> = AppResult.Success("report")
}
