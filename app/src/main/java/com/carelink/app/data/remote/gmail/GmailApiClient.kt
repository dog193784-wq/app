package com.carelink.app.data.remote.gmail

import javax.inject.Inject

class GmailApiClient @Inject constructor() {
    suspend fun sendHtmlReport(subject: String, htmlBody: String, recipients: List<String>): Result<Unit> = Result.success(Unit)
}
