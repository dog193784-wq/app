package com.carelink.app.di

import com.carelink.app.data.repository.*
import com.carelink.app.domain.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds @Singleton abstract fun bindHealthRepo(impl: HealthDataRepositoryImpl): HealthDataRepository
    @Binds @Singleton abstract fun bindAlertRepo(impl: AlertRepositoryImpl): AlertRepository
    @Binds @Singleton abstract fun bindReportRepo(impl: ReportRepositoryImpl): ReportRepository
    @Binds @Singleton abstract fun bindDeliveryRepo(impl: DeliveryRepositoryImpl): DeliveryRepository
}
