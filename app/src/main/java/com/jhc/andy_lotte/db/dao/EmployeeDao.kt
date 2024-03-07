package com.jhc.andy_lotte.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jhc.andy_lotte.db.entity.EmployeeEntity

@Dao
interface EmployeeDao {
    @Insert
    fun insert(entities: EmployeeEntity)
}