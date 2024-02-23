package com.jhc.andy_lotte.module

import com.jhc.andy_lotte.api.service.AppAdminService
import com.jhc.andy_lotte.repository.AdminRepository
import com.jhc.andy_lotte.repository.AdminRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideAdminRepository(@Named("admin")retrofit: AppAdminService): AdminRepository = AdminRepositoryImpl(retrofit)

}