package com.jhc.andy_lotte.repository.db

import android.util.Log
import com.jhc.andy_lotte.db.AppDataBase
import com.jhc.andy_lotte.db.entity.ZipEntity
import javax.inject.Inject

class DBRepositoryImpl @Inject constructor(
    private val database: AppDataBase
) : DBRepository {
    override suspend fun insertData() {
        Log.i("gyeom","Eeee")
        database.zipDao().insert(ZipEntity(7,1,"z"))
    }


}