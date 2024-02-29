package com.jhc.andy_lotte.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.jhc.andy_lotte.db.entity.ZipEntity

@Dao
interface ZipDao {

    @Insert
    fun insert(entities: ZipEntity)

}