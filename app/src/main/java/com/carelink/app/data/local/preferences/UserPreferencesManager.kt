package com.carelink.app.data.local.preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore(name = "carelink_settings")

@Singleton
class UserPreferencesManager @Inject constructor(@ApplicationContext private val context: Context) {
    private val syncIntervalKey = intPreferencesKey("sync_interval_minutes")
    val syncInterval: Flow<Int> = context.dataStore.data.map { it[syncIntervalKey] ?: 60 }
    suspend fun setSyncInterval(minutes: Int) = context.dataStore.edit { it[syncIntervalKey] = minutes }
}
