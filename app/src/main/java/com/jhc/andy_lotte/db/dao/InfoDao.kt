package com.jhc.andy_lotte.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.jhc.andy_lotte.db.entity.InfoEntity

@Dao
interface InfoDao {
    @Insert
    fun insert(entities: InfoEntity)
}