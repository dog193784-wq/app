package com.carelink.app.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Light = lightColorScheme(primary = Color(0xFF0F172A), secondary = Color(0xFF94A3B8))
private val Dark = darkColorScheme(primary = Color(0xFF94A3B8), secondary = Color(0xFF0F172A))

@Composable
fun CareLinkTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = Light, content = content)
}
