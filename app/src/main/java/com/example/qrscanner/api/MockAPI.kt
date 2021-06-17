package com.example.qrscanner.api

import com.example.qrscanner.activity.mainActivity.model.ScanHistory
import retrofit2.http.Headers
import retrofit2.http.POST

interface MockAPI {
    @POST("posts")
    @Headers("Content-type: application/json; charset=UTF-8")
    suspend fun postScanHistory(data: List<ScanHistory>)
}