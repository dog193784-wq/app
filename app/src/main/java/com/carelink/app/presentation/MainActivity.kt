package com.carelink.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.carelink.app.presentation.navigation.NavGraph
import com.carelink.app.presentation.theme.CareLinkTheme
import dagger.hilt.android.AndroidEntryPoint

/** Main host activity for Compose navigation. */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CareLinkTheme {
                NavGraph()
            }
        }
    }
}
