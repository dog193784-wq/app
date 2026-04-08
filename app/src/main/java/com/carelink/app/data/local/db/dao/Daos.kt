package com.carelink.app.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.carelink.app.data.local.db.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface HealthDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<HealthDataEntity>)

    @Query("SELECT * FROM health_data WHERE parent_id = :parentId ORDER BY timestamp DESC")
    fun observeByParent(parentId: String): Flow<List<HealthDataEntity>>
}

@Dao
interface AlertRuleDao { @Query("SELECT * FROM alert_rules WHERE parent_id = :parentId AND enabled = 1") suspend fun getEnabled(parentId: String): List<AlertRuleEntity> }
@Dao
interface ReportConfigDao { @Query("SELECT * FROM report_configs WHERE parent_id = :parentId") suspend fun getByParent(parentId: String): List<ReportConfigEntity> }
@Dao
interface DeliveryLogDao { @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insert(log: DeliveryLogEntity) }
@Dao
interface ParentProfileDao { @Query("SELECT * FROM parent_profiles") suspend fun getAll(): List<ParentProfileEntity>; @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun upsert(profile: ParentProfileEntity) }
