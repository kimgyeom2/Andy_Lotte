package com.jhc.andy_lotte.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jhc.andy_lotte.db.entity.ZipEntity

@Dao
interface ZipDao {

    @Insert
    fun insert(entities: ZipEntity)
    @Query("SELECT COUNT(*) FROM zip")
    fun getAll(): Int
}