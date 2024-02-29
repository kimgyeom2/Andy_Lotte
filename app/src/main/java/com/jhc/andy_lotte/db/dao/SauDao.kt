package com.jhc.andy_lotte.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.jhc.andy_lotte.db.entity.SauEntity

@Dao
interface SauDao {

    @Insert
    fun insert(entities: SauEntity)

}