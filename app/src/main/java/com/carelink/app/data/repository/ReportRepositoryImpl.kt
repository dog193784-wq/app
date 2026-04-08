package com.carelink.app.data.repository

import com.carelink.app.domain.model.ReportType
import com.carelink.app.domain.repository.ReportRepository
import javax.inject.Inject

class ReportRepositoryImpl @Inject constructor() : ReportRepository {
    override suspend fun generate(parentId: String, reportType: ReportType): Result<String> = Result.success("report")
}
