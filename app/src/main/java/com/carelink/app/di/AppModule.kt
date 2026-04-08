package com.carelink.app.di

import com.carelink.app.data.provider.GoogleFitProvider
import com.carelink.app.data.provider.HealthDataProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides fun providePrimaryProvider(provider: GoogleFitProvider): HealthDataProvider = provider
}
