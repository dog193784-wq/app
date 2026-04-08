package com.carelink.app.data.remote.telegram

object TelegramMessageFormatter {
    fun alert(title: String, value: String): String = "🚨 *$title*
`$value`"
}
