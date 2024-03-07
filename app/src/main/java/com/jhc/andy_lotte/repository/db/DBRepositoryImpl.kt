package com.jhc.andy_lotte.repository.db

import com.jhc.andy_lotte.db.AppDataBase
import javax.inject.Inject

class DBRepositoryImpl @Inject constructor(
    private val database: AppDataBase
) : DBRepository {
    override suspend fun insertData() {
    }


}