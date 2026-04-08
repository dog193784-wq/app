package com.carelink.app.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/** Simple app navigation graph scaffold. */
@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") { Text("CareLink Dashboard") }
        composable("history") { Text("Health History") }
        composable("alerts") { Text("Alerts") }
        composable("settings") { Text("Settings") }
    }
}
