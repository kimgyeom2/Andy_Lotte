package com.jhc.andy_lotte.repository

import com.jhc.andy_lotte.api.request.UpdateVersionRequest
import com.jhc.andy_lotte.api.service.AppAdminService
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AdminRepositoryImpl @Inject constructor(
    private val adminService: AppAdminService
) : AdminRepository {

    override suspend fun getVersion() = flow {
        emit(adminService.getUpdateVersion(UpdateVersionRequest("andy_lotte_test")))
    }


}