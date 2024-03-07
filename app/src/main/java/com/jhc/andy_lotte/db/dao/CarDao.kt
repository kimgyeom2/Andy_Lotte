package com.jhc.andy_lotte.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.jhc.andy_lotte.db.entity.CarEntity

@Dao
interface CarDao {
    @Insert
    fun insert(vararg entities: CarEntity)
}