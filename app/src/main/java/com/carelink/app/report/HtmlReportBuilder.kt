package com.carelink.app.report

import com.carelink.app.domain.model.HealthData
import com.carelink.app.domain.model.ReportConfig
import javax.inject.Inject

class HtmlReportBuilder @Inject constructor() {
    fun build(config: ReportConfig, data: List<HealthData>): String = """
        <html><body><h1>CareLink ${config.reportType}</h1><p>Entries: ${data.size}</p></body></html>
    """.trimIndent()
}
