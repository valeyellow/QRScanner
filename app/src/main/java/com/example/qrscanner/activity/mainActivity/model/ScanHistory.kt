package com.example.qrscanner.activity.mainActivity.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "scan_history_table"
)
data class ScanHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val timeStamp: String,
    val content: String
)
