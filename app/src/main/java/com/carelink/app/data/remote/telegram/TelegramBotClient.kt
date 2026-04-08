package com.carelink.app.data.remote.telegram

import kotlinx.coroutines.delay
import javax.inject.Inject

class TelegramBotClient @Inject constructor() {
    suspend fun sendMessage(chatId: String, text: String): Result<Unit> {
        val delays = listOf(1000L, 4000L, 16000L)
        repeat(3) { idx ->
            runCatching { return Result.success(Unit) }
            if (idx < 2) delay(delays[idx])
        }
        return Result.failure(IllegalStateException("Unable to deliver Telegram message"))
    }
}
