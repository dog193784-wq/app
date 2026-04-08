package com.carelink.app.report

import com.carelink.app.domain.model.HealthData
import com.carelink.app.domain.model.ReportConfig
import javax.inject.Inject

class ReportGenerator @Inject constructor(private val htmlReportBuilder: HtmlReportBuilder, private val telegramReportFormatter: TelegramReportFormatter) {
    fun generateHtml(config: ReportConfig, data: List<HealthData>): String = htmlReportBuilder.build(config, data)
    fun generateTelegramMarkdown(config: ReportConfig, data: List<HealthData>): String = telegramReportFormatter.format(config, data)
}
