package com.example.qrscanner.di

import android.content.Context
import androidx.room.Room
import com.example.qrscanner.db.ScanHistoryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, ScanHistoryDatabase::class.java, "scan_history_table")
            .fallbackToDestructiveMigration().build()

    @Provides
    fun provideScanHistoryDao(db: ScanHistoryDatabase) = db.ScanHistoryDao()

}