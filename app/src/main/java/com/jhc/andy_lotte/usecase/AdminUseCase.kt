package com.jhc.andy_lotte.usecase

import com.jhc.andy_lotte.repository.admin.AdminRepository
import com.jhc.andy_lotte.repository.db.DBRepository
import javax.inject.Inject

class AdminUseCase  @Inject constructor(private  val mapRepository: AdminRepository,private  val db: DBRepository) {

    suspend fun getVersion()=mapRepository.getVersion()

    suspend fun db()=db.insertData()
}