package com.jhc.andy_lotte.api.service


import com.jhc.andy_lotte.api.request.UpdateVersionRequest
import com.jhc.andy_lotte.api.service.respone.UpdateVersionResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.POST

interface AppAdminService {
    @POST("appinfo/info")
    suspend fun getUpdateVersion(@Body request: UpdateVersionRequest): UpdateVersionResponse
}