package com.carelink.app.di

import android.content.Context
import androidx.room.Room
import com.carelink.app.data.local.db.CareLinkDatabase
import com.carelink.app.data.local.db.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides @Singleton fun provideDb(@ApplicationContext context: Context): CareLinkDatabase = Room.databaseBuilder(context, CareLinkDatabase::class.java, "carelink.db").fallbackToDestructiveMigration().build()
    @Provides fun healthDataDao(db: CareLinkDatabase): HealthDataDao = db.healthDataDao()
    @Provides fun alertRuleDao(db: CareLinkDatabase): AlertRuleDao = db.alertRuleDao()
    @Provides fun reportConfigDao(db: CareLinkDatabase): ReportConfigDao = db.reportConfigDao()
    @Provides fun deliveryLogDao(db: CareLinkDatabase): DeliveryLogDao = db.deliveryLogDao()
    @Provides fun parentProfileDao(db: CareLinkDatabase): ParentProfileDao = db.parentProfileDao()
}
