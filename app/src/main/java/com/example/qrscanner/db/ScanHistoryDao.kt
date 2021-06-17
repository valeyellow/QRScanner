package com.example.qrscanner.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.qrscanner.activity.mainActivity.model.ScanHistory

@Dao
interface ScanHistoryDao {
    @Query("SELECT * FROM scan_history_table")
    fun getHistory(): List<ScanHistory>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(history: ScanHistory)
}
