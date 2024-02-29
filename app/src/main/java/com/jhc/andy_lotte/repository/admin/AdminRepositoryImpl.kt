package com.jhc.andy_lotte.repository.admin

import com.jhc.andy_lotte.api.request.UpdateVersionRequest
import com.jhc.andy_lotte.api.service.AppAdminService
import com.jhc.andy_lotte.repository.admin.AdminRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AdminRepositoryImpl @Inject constructor(
    private val adminService: AppAdminService
) : AdminRepository {

    override suspend fun getVersion() = flow {
        emit(adminService.getUpdateVersion(UpdateVersionRequest("andy_lotte_test")))
    }


}