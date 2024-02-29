package com.jhc.andy_lotte.repository.admin

import com.jhc.andy_lotte.api.service.respone.UpdateVersionResponse
import kotlinx.coroutines.flow.Flow

interface AdminRepository {

    suspend fun getVersion(): Flow<UpdateVersionResponse>

}