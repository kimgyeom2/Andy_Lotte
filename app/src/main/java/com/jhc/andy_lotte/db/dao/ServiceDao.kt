package com.jhc.andy_lotte.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.jhc.andy_lotte.db.entity.ServiceEntity

@Dao
interface ServiceDao {
    @Insert
    fun insert(entities: ServiceEntity)
}