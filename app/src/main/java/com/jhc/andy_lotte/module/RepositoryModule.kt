package com.jhc.andy_lotte.module

import com.jhc.andy_lotte.api.service.AppAdminService
import com.jhc.andy_lotte.db.AppDataBase
import com.jhc.andy_lotte.db.dao.CarInfoDao
import com.jhc.andy_lotte.db.dao.EmployeeDao
import com.jhc.andy_lotte.db.dao.InfoDao
import com.jhc.andy_lotte.db.dao.OfficeDao
import com.jhc.andy_lotte.db.dao.SauDao
import com.jhc.andy_lotte.db.dao.ServiceDao
import com.jhc.andy_lotte.db.dao.ZipDao
import com.jhc.andy_lotte.repository.admin.AdminRepository
import com.jhc.andy_lotte.repository.admin.AdminRepositoryImpl
import com.jhc.andy_lotte.repository.db.DBRepository
import com.jhc.andy_lotte.repository.db.DBRepositoryImpl
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
    fun provideAdminRepository(@Named("admin") retrofit: AppAdminService): AdminRepository =
        AdminRepositoryImpl(retrofit)

    @Provides
    @Singleton
    fun provideDBRepository(
       database: AppDataBase
    ): DBRepository = DBRepositoryImpl(database)

}