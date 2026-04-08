package com.carelink.app.report

import com.carelink.app.domain.model.HealthData
import com.carelink.app.domain.model.ReportConfig
import javax.inject.Inject

class TelegramReportFormatter @Inject constructor() {
    fun format(config: ReportConfig, data: List<HealthData>): String = "*CareLink ${config.reportType}*
Total entries: `${data.size}`"
}
