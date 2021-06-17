package com.example.qrscanner.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.qrscanner.activity.mainActivity.model.ScanHistory

@Database(
    entities = [ScanHistory::class],
    version = 1
)
abstract class ScanHistoryDatabase : RoomDatabase() {
    abstract fun ScanHistoryDao(): ScanHistoryDao
}