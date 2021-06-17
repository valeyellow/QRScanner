package com.example.qrscanner.di

import android.content.Context
import androidx.room.Room
import com.example.qrscanner.api.MockAPI
import com.example.qrscanner.db.ScanHistoryDatabase
import com.example.qrscanner.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient
            .Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    @Provides
    @Singleton
    fun provideRetrofitInstance(retrofit: Retrofit): MockAPI = retrofit.create(MockAPI::class.java)


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, ScanHistoryDatabase::class.java, "scan_history_table")
            .fallbackToDestructiveMigration().build()

    @Provides
    fun provideScanHistoryDao(db: ScanHistoryDatabase) = db.ScanHistoryDao()

}