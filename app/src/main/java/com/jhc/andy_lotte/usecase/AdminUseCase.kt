package com.jhc.andy_lotte.usecase

import com.jhc.andy_lotte.repository.AdminRepository
import javax.inject.Inject

class AdminUseCase  @Inject constructor(private  val mapRepository: AdminRepository) {

    suspend fun getVersion()=mapRepository.getVersion()

}